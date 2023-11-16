package com.teste.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.blog.service.AlbumService;
import com.teste.blog.service.UserService;

@RestController
@RequestMapping("/albums")
public class AlbumController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private AlbumService albumService;
	
	@Autowired
	private HttpServletRequest request;

   
}

