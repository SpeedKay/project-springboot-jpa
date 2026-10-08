package com.example.jpa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.jpa.entities.User;
import com.example.jpa.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
	
		User u1 = new User(null, "Ronaldinho soccer", "ronaldinho@gmail.com", "91872407", "123456");
		User u2 = new User(null, "Chama", "chama@gmail.com", "991829407", "654321");

		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
}
