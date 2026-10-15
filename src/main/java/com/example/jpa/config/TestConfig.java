package com.example.jpa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.jpa.entities.Order;
import com.example.jpa.entities.User;
import com.example.jpa.entities.enuns.OrderStatus;
import com.example.jpa.repositories.OrderRepository;
import com.example.jpa.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	

	@Override
	public void run(String... args) throws Exception {
	
		User u1 = new User(null, "Ronaldinho soccer", "ronaldinho@gmail.com", "91872407", "123456");
		User u2 = new User(null, "Chama", "chama@gmail.com", "991829407", "654321");
		
		Order o1 = new Order(null, Instant.parse("2026-10-12T19:16:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2026-11-13T20:30:03Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2026-12-13T23:59:59Z"), OrderStatus.WAITING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
