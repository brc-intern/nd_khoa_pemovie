package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Repository.Userrepository;
import com.example.demo.model.User;

@Service
public class Userservice {
@Autowired private Userrepository repo;

public User fetchemployeebyusername(String tempusername) {
	// TODO Auto-generated method stub
	return repo.findByUsername(tempusername);
}

public User register(User lgmd) {
	// TODO Auto-generated method stub
	return repo.save(lgmd);
}

public User fetchloginmodel(String tempusername, String temppasswork) {
	return repo.findByUsernameAndPassword(tempusername, temppasswork);
	
}

}
