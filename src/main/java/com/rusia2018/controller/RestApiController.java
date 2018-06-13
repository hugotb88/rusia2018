package com.rusia2018.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rusia2018.model.Match;
import com.rusia2018.model.Team;
import com.rusia2018.model.User;
import com.rusia2018.repository.MatchRepository;
import com.rusia2018.repository.TeamRepository;
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
	
	@Autowired
	TeamRepository teamRepository;
	
	
 
    // ------------------- Users -------------------------------------------
	// Create a new User
	@PostMapping("/user/{idUser}")
	public User createUser(@PathVariable("idUser") int idUser, @RequestBody User user) {
		User userRes = new User();
		userRes = userRepository.checkIfUserExist(user.getIdUser());
		if(userRes != null) {
			System.out.println("El user existe, ve por sus partidos");
		}else {
			userRes = userRepository.save(user);
		}
	    return userRes;
	}
	
	
	// Get Scores of all users
	@GetMapping("/user/scores")
	public List<User> getAllScores() {
		ArrayList<User> scoresOfAll = new ArrayList<User>();
		scoresOfAll = (ArrayList<User>) userRepository.getScoresOfAll();
	    return scoresOfAll;
	}
	
	
	
	// ------------------- Teams -------------------------------------------
	@GetMapping("/team/getAll")
	public List<Team> getAllTeams() {
		ArrayList<Team> allTeams = new ArrayList<Team>();
		allTeams = (ArrayList<Team>) teamRepository.getAllTeams();
	    return allTeams;
	}
	
	@GetMapping("/team/{id}")
	public Team getTeamById(@PathVariable("id") int id) {
		Team team = new Team();
		team = teamRepository.getTeamById(id);
	    return team;
	}
	
	
	// ------------------- Matches -------------------------------------------
	@GetMapping("/matches/getAll")
	public List<Match> getAllMatches() {
		ArrayList<Match> allMatches = new ArrayList<Match>();
		allMatches = (ArrayList<Match>) matchRepository.getAllMatches();
	    return allMatches;
	}
	
	@GetMapping("/matches/{idMatches}")
	public Match getMatchById(@PathVariable("idMatches") int idMatches) {
		Match match = new Match();
		match = matchRepository.getMatchById(idMatches);
	    return match;
	}
	
     
}
