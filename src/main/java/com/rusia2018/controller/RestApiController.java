package com.rusia2018.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rusia2018.model.User;
import com.rusia2018.repository.MatchRepository;
import com.rusia2018.repository.UserRepository;

/**
 * @author victor olvera
 * REST Controller
 */

@RestController
@RequestMapping("/api")
public class RestApiController {
	
	//Add log
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
	UserRepository userRepository; //Service to get information from user
	
	@Autowired
	MatchRepository matchRepository;
	
	
 
    // -------------------New User-------------------------------------------
	// Create a new User
	@PostMapping("/user/{idUser}")
	public User createUser(@PathVariable("idUser") int idUser) {
		User user = new User(idUser, 0, false);
	    return userRepository.save(user);
	}
     
}
