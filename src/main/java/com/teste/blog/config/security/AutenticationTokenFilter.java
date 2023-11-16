package com.teste.blog.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.teste.blog.model.Users;
import com.teste.blog.repository.UserRepository;
import com.teste.blog.service.TokenService;

@Service
public class AutenticationTokenFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	private UserRepository repository;
	
	public AutenticationTokenFilter(TokenService tokenService, UserRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = retrieveToken(request);
		boolean valid = tokenService.isTokenValid(token);
		
		if(valid) {
			autenticationClient(token);
		}
		
		filterChain.doFilter(request, response);
		
	}

	private void autenticationClient(String token) {
		
		String username = tokenService.getUsernameUser(token);
		Users user = repository.findByUsername(username);
		
		if(user != null) {
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, null);
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
	}

	private String retrieveToken(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		if( token == null || token.isEmpty() ) {
			return null;
		}
		return token;
	}
}
