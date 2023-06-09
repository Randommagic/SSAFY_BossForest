package com.ssafy.raid.auth.config;

import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.raid.auth.dto.Account;
import com.ssafy.raid.auth.dto.builder.LoginResponseBuilder;
import com.ssafy.raid.auth.exception.BadRequestException;
import com.ssafy.raid.auth.filter.AccountUsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig{
	
	@Autowired UserDetailsService userDetailsService;
	
	@Autowired ObjectMapper objectMapper;
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/account").permitAll()
                .antMatchers(HttpMethod.GET, "/account/id").permitAll()
                .anyRequest().authenticated()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and()
            .addFilterBefore(jsonUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
            .formLogin()
            	.loginProcessingUrl("/login")
            .and()
            .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
    			.deleteCookies("SESSION")
                .logoutSuccessHandler(logoutSuccessHandler());
        return http.build();
    }
	
	@Bean
    public AccountUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter() {
        AccountUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter = new AccountUsernamePasswordAuthenticationFilter(objectMapper, authenticationSuccessHandler(), authenticationFailureHandler());
        jsonUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManager());
        return jsonUsernamePasswordAuthenticationFilter;
    }
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
	    return (request, response, authentication) -> {
	        Account account = (Account) authentication.getPrincipal();
	        response.setStatus(HttpServletResponse.SC_OK);
	        response.setContentType("application/json");
	        byte[] sessionId = request.getSession().getId().getBytes();
	        Encoder encoder = getSessionIdEncoder();
	        String playerKey = new String(encoder.encode(sessionId));
	        response.getWriter().write(new ObjectMapper().writeValueAsString(LoginResponseBuilder.AuthComplete(account, playerKey)));
	    };
	}
	
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
	    return (request, response, exception) -> {
	    	System.out.println(exception.getClass());
	    	if(exception instanceof BadCredentialsException) {
	    		response.setStatus(HttpServletResponse.SC_OK);
		        response.setContentType("application/json");
		        response.getWriter().write(new ObjectMapper().writeValueAsString(LoginResponseBuilder.AuthFailed()));
	    	}else if(exception instanceof BadRequestException){
	    		response.setStatus(HttpServletResponse.SC_OK);
		        response.setContentType("application/json");
	        	response.getWriter().write(new ObjectMapper().writeValueAsString(LoginResponseBuilder.InvalidParameters()));
	    	}else {
	    		response.setStatus(HttpServletResponse.SC_OK);
		        response.setContentType("application/json");
		        response.getWriter().write(new ObjectMapper().writeValueAsString(LoginResponseBuilder.AuthIsIncomplete()));
	    	}
	    };
	}
	
	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
	    return (request, response, authentication) -> {
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	    };
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
	}
	
	@Bean
	public Encoder getSessionIdEncoder() {
		return Base64.getEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(provider);
    }

}