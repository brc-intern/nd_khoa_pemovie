package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.movie;

public interface movierepository extends JpaRepository<movie, Long> {
	List<movie> findByNameContaining(String name);
}
