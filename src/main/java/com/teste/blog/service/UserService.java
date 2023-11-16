package com.teste.blog.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.teste.blog.controller.dto.LoginDto;
import com.teste.blog.controller.dto.TokenDto;
import com.teste.blog.controller.dto.UserDto;
import com.teste.blog.model.Users;
import com.teste.blog.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenService tokenService;
	
	public Users retrieveUser(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		
		if( token == null || token.isEmpty() ) {
			return null;
		}
		
		boolean valid = tokenService.isTokenValid(token);
		
		if(valid) {
			String username = tokenService.getUsernameUser(token);
			return userRepository.findByUsername(username);
		}
		
		return null;
	}

	public void register(UserDto dto) {
		
		String encodedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
		
		Users user = new Users(dto.getName(), dto.getUsername(), encodedPassword);
		
		userRepository.save(user);
	}

	public TokenDto login( LoginDto dto ) throws Exception {
		
		Users user = userRepository.findByUsername(dto.getUsername());
		
		if(user == null) throw new Exception();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		
		if( !encoder.matches(dto.getPassword(), user.getPassword())) throw new Exception();
		
		String token = tokenService.generateToken(user);
		
		return new TokenDto(token);
	}

}
