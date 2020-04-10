package com.jwt.loginservice;

import com.jwt.loginservice.entities.User;
import com.jwt.loginservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class LoginServiceApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init(){
		List<User> users = Stream.of(
				new User(1L,"Shaminda","1234"),
				new User(2L,"Ruwanaari","1234"),
				new User(3L,"Amila","1234")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}

//	@Bean
//	BCryptPasswordEncoder bCryptPasswordEncoder(){
//		return new BCryptPasswordEncoder();
//	}
	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}

}
