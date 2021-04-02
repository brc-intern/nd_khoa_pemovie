package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.movie;
import com.example.demo.service.Movieservice;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
public class MovieController {
	@Autowired
	Movieservice service;

	@PostMapping("/create")
	public movie postProduct(@RequestBody movie product) {
		String a = product.getImage();
		String b = "";
		b = a.substring(12);
		product.setImage(b);
		movie _product = service.ListProduct(new movie(product.getName(), product.getImage()));
		return _product;
	}

	@GetMapping("/getproduct/{id}")
	public ResponseEntity<movie> getProductById(@PathVariable("id") long id) {
		Optional<movie> productData = service.findById(id);

		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/getallproduct")
	public ResponseEntity<List<movie>> getAllProduct(@RequestParam(required = false) String name) {
		try {
			List<movie> product = new ArrayList<movie>();
			if(name == null) {
				service.findAll().forEach(product::add);
			}else {
				service.findByName(name).forEach(product::add);
			}
			if(product.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<movie> deleteAnimals(@PathVariable("id") long id) {
		System.out.println("Delete Animals with id = " + id + "....");
		service.deleteByid(id);
		return new ResponseEntity<movie>(HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<movie> updateAnimals(@PathVariable("id") long id, @RequestBody movie product) {
		System.out.println("Update Animal with id = " + id + "...");
		Optional<movie> productData = service.findById(id);
		

		if (productData.isPresent()) {
			String a = product.getImage();
			String b ="";
			b=a.substring(12);
			product.setImage(b);
			movie _product = productData.get();
			_product.setImage(product.getImage());
			_product.setName(product.getName());
			
			return new ResponseEntity<>(service.ListProduct(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
