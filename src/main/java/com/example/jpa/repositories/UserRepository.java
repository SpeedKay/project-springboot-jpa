package com.example.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
