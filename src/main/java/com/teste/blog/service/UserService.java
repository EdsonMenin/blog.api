package com.teste.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.teste.blog.controller.dto.TokenDto;
import com.teste.blog.controller.dto.UserDto;
import com.teste.blog.model.User;
import com.teste.blog.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenService tokenService;

	public void register(UserDto dto) {
		
		String encodedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
		
		User user = new User(dto.getName(), dto.getUsername(), encodedPassword);
		
		userRepository.save(user);
	}

	public TokenDto login(String username, String password) throws Exception {
		
		User user = userRepository.findByUsername(username);
		
		if(user == null) throw new Exception();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		
		if( !encoder.matches(password, user.getPassword())) throw new Exception();
		
		String token = tokenService.generateToken(user);
		
		return new TokenDto(token);
	}

}
