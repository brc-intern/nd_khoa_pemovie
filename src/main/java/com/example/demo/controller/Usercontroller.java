package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.Userservice;

 

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Usercontroller {
	
	@Autowired Userservice s;
	@PostMapping("/registuser")
	public User regisuser(@RequestBody User lgmd) throws Exception {
		 String tempusername = lgmd.getUsername();
		 if(tempusername != null && !"".equals(tempusername)) {
			User lgmdobj = s.fetchemployeebyusername(tempusername);
			if(lgmdobj != null) {
				throw new Exception("user with name " +tempusername+" is already exits");
			}
		 }
		User lgmdd = null;
		lgmdd = s.register(new User(lgmd.getUsername(),lgmd.getPassword(), "user"));
		return lgmdd;
	}
	@PostMapping("/registadmin")
	public User regisadmin(@RequestBody User lgmd) throws Exception {
		 String tempusername = lgmd.getUsername();
		 if(tempusername != null && !"".equals(tempusername)) {
			User lgmdobj = s.fetchemployeebyusername(tempusername);
			if(lgmdobj != null) {
				throw new Exception("user with name " +tempusername+" is already exits");
			}
		 }
		User lgmdd = null;
		lgmdd = s.register(new User(lgmd.getUsername(),lgmd.getPassword(), "admin"));
		return lgmdd;
	}
	@PostMapping("/login")
	public String login(@RequestBody User llgmd) throws Exception { 
		String tempusername = llgmd.getUsername();
		String temppasswork = llgmd.getPassword(); 
		User lgmmd = s.fetchloginmodel(tempusername, temppasswork);
		if(lgmmd == null) {
			throw new Exception("badass");
		}
		return lgmmd.getRole();
	}
}
