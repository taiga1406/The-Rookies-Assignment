package com.example.demo.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	Optional<Account> findByUsername(String username);

	Boolean existsByUsername(String username);
}
