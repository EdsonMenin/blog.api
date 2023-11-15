package com.teste.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.blog.controller.dto.UserDto;
import com.teste.blog.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Object> register( UserDto dto ) {
		
		try {
			
			userService.register(dto);
			
			return  new ResponseEntity<Object>( "Usuário cadastrado com sucesso!", HttpStatus.OK);
		
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity<Object>("Email ja cadastrado!", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login( String username, String password ) {
		
		try {
		
			return  new ResponseEntity<Object>( userService.login(username, password), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Object>("Email ou senha incorreta!", HttpStatus.UNAUTHORIZED);
		}
	}

}
