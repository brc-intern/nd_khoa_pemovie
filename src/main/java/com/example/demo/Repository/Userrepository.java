package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface Userrepository extends JpaRepository<User, Long> {

	public User findByUsername(String tempusername);



	public User findByUsernameAndPassword(String tempusername, String temppasswork);

}

