package com.ssafy.raid.auth.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
import com.ssafy.raid.auth.dto.builder.ResponseBuilder;
import com.ssafy.raid.auth.filter.RequestParameterValidationFilter;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig{
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
            .and()
            .addFilterBefore(new RequestParameterValidationFilter(), UsernamePasswordAuthenticationFilter.class)
            .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandler());
        return http.build();
    }
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
	    return (request, response, authentication) -> {
	        Account account = (Account) authentication.getPrincipal();
	        response.setStatus(HttpServletResponse.SC_OK);
	        response.setContentType("application/json");
	        response.getWriter().write(new ObjectMapper().writeValueAsString(ResponseBuilder.AuthComplete(account)));
	    };
	}
	
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
	    return (request, response, exception) -> {
	    	System.out.println(exception.getClass());
	    	if(exception instanceof BadCredentialsException) {
	    		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		        response.setContentType("application/json");
		        response.getWriter().write(new ObjectMapper().writeValueAsString(ResponseBuilder.AuthFailed()));
	    	}else {
	    		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		        response.setContentType("application/json");
		        response.getWriter().write(new ObjectMapper().writeValueAsString(ResponseBuilder.AuthIsIncomplete()));
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

	public void configureGlobal(
			@Autowired AuthenticationManagerBuilder auth, 
			@Autowired UserDetailsService userDetailsService, 
			@Autowired PasswordEncoder passwordEncoder
		) throws Exception {
	    auth
	        .userDetailsService(userDetailsService)
	        .passwordEncoder(passwordEncoder);
	}
}