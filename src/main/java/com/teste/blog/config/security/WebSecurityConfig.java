package com.teste.blog.config.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.teste.blog.repository.UserRepository;
import com.teste.blog.service.TokenService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	private UserRepository repository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
	      	.authorizeRequests()
	      	.antMatchers("/").permitAll()
	      	.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	      	.antMatchers("/user/**").permitAll()
	      	.anyRequest().authenticated()
	      	.and().csrf().disable()
	      	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	      	.and().addFilterBefore(new AutenticationTokenFilter(tokenService, repository ), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
    public CorsFilter corsFilter() {
    	
    	CorsConfiguration configuration = new CorsConfiguration();
    	configuration.setAllowCredentials(true);
	    configuration.setAllowedOrigins(Arrays.asList("*"));
	    configuration.setAllowedMethods(Arrays.asList("*"));
	    configuration.setAllowedHeaders(Arrays.asList("*"));
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return new CorsFilter(source);
    	
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
