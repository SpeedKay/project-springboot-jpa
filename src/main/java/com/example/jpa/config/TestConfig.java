package com.example.jpa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.jpa.entities.Category;
import com.example.jpa.entities.Order;
import com.example.jpa.entities.OrderItem;
import com.example.jpa.entities.Payment;
import com.example.jpa.entities.Product;
import com.example.jpa.entities.User;
import com.example.jpa.entities.enuns.OrderStatus;
import com.example.jpa.repositories.CategoryRepository;
import com.example.jpa.repositories.OrderItemRepository;
import com.example.jpa.repositories.OrderRepository;
import com.example.jpa.repositories.ProductRepository;
import com.example.jpa.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computas");
		
		Product p1 = new Product(null, "Senhor dos Anais", "abecedario", 99.99, "");
		Product p2 = new Product(null, "Tevelisão Lenovo", "acebedario", 9999.99, "");
		Product p3 = new Product(null, "Notebook Pro", "adebecario", 6666.66, "");
		Product p4 = new Product(null, "PC Gay Mer", "arebecario", 166.666, "");
		Product p5 = new Product(null, "Harry Potter", "oiradeceba", 66.66, "");
		
		User u1 = new User(null, "Ronaldinho soccer", "ronaldinho@gmail.com", "91872407", "123456");
		User u2 = new User(null, "Chama", "chama@gmail.com", "991829407", "654321");
		
		Order o1 = new Order(null, Instant.parse("2026-10-12T19:16:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2026-11-13T20:30:03Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2026-12-13T23:59:59Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p1.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1= new Payment(null, Instant.parse("2026-10-12T21:16:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}
	
}
