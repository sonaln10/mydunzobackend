package com.mydunzo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
	
	@Autowired
	UserRepository repository;
	
	
	@GetMapping("/findall")
	public List<User> findAll(){
	List<User> users = repository.findAll();
	System.out.println("userList: "+users);
	return users;
	}
}
