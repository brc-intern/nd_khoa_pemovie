package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.movierepository;
import com.example.demo.model.movie;

@Service
public class Movieservice {
	@Autowired
	movierepository mr;
	
	public movie ListProduct(movie movie){
		return mr.save(movie);
	}
	
	public List<movie> findByName(String name){
		return mr.findByNameContaining(name);
	}
	
	public Optional<movie> findById(long id) {
		return mr.findById(id);
	}
	public List<movie> findAll(){
		return mr.findAll();
	}
	public void deleteByid(long id) {
		mr.deleteById(id);
	}
}
