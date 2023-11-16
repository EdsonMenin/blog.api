package com.teste.blog.service;

import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.teste.blog.model.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class TokenService {
	
	@Value("${bet.jwt.expiration}")
	private String expiration;
	
	@Value("${bet.jwt.secret}")
	private String secret;

	public String generateToken(Users user) {
		
		Date date = new Date();
		Date dateEx = new Date(date.getTime() + Long.parseLong( expiration ) );

		return Jwts.builder()
			       .setIssuer("API LOGIN")
			       .setSubject(user.getUsername())
			       .setIssuedAt(date)
			       .setExpiration(dateEx)
			       .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secret.getBytes()))
			       .compact();
	}

	public boolean isTokenValid(String token) {
		
		try {
			
			Jwts.parser()
				.setSigningKey( Base64.getEncoder().encode(secret.getBytes()))
				.parseClaimsJws(token);			
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	public String getUsernameUser(String token) {
		
		Claims body = Jwts.parser()
						  .setSigningKey( Base64.getEncoder().encode(secret.getBytes()))
						  .parseClaimsJws(token)
						  .getBody();
		return body.getSubject();
	}

}
