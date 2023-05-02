package com.ssafy.raid.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.raid.auth.dto.builder.ResponseBuilder;

public class RequestParameterValidationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null || username.isBlank() || password.isBlank()) {
        	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        response.setContentType("application/json");
        	response.getWriter().write(new ObjectMapper().writeValueAsString(ResponseBuilder.InvalidParameters()));
            return;
        }

        filterChain.doFilter(request, response);
    }
}