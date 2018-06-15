package com.rusia2018.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rusia2018.model.Match;
import com.rusia2018.model.StaticMatches;
import com.rusia2018.model.Team;
import com.rusia2018.model.User;
import com.rusia2018.model.UserMatches;
import com.rusia2018.repository.MatchRepository;
import com.rusia2018.repository.StaticMatchesRepository;
import com.rusia2018.repository.TeamRepository;
import com.rusia2018.repository.UserMatchesRepository;
import com.rusia2018.repository.UserRepository;

/**
 * @author victor olvera
 * REST Controller
 */

@RestController
@CrossOrigin
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
	
	@Autowired
	UserMatchesRepository userMatchesRepository;
	
	@Autowired
	StaticMatchesRepository staticMatchesRepository;
 
    // ------------------- Users -------------------------------------------
	// Create a new User
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		User userRes = new User();
		userRes = userRepository.checkIfUserExist(user.getIdUser());
		if(userRes != null) {
			System.out.println("El user existe, ve por sus partidos");
			ArrayList<UserMatches> listUserMatches = new ArrayList<UserMatches>();
			listUserMatches = (ArrayList<UserMatches>) userMatchesRepository.getAllUserMatches(user.getIdUser());
			userRes.setMatches(listUserMatches);
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
	
	//Update user score
	@PutMapping("/user/updateScore")
	public User updateUserScore(@RequestBody User user) {
		Integer res = userRepository.updateUserScore(user.getTotalScore(), user.getIdUser());
	    if (res == 0) {
	    	System.out.println("not updated");
	    }else{
	    	System.out.println("updated");
	    }
		return user;
	}
	
	//Get finished matches for user
	@GetMapping(value = "/user/finishedMatches/{idUser}")
	public User getFinishedMatchesForUserId(@PathVariable("idUser") Long idUser) {
		User userRes = new User();
		userRes = userRepository.checkIfUserExist(idUser);
		if(userRes != null) {
			System.out.println("El user existe, ve por sus partidos finalizados");
			ArrayList<UserMatches> listFinishedUserMatches = new ArrayList<UserMatches>();
			listFinishedUserMatches = (ArrayList<UserMatches>) userMatchesRepository.getFinishedMatchesByUser(idUser);
			userRes.setMatches(listFinishedUserMatches);
		}
	    return userRes;
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
	
	
	// ------------------- User Matches -------------------------------------------
	@PostMapping("/user/matches")
	public UserMatches createUserMatches(@RequestBody UserMatches userMatches) {
		UserMatches userMatchesRes = new UserMatches();
		userMatchesRes = userMatchesRepository.checkIfUserMatchesExist(userMatches.getIdUser(),userMatches.getName());
		if(userMatchesRes != null) {
			System.out.println("El Match existe, llamar al metodo PUT para actualizar");
			userMatches.setIdUserMatches(userMatchesRes.getIdUserMatches());
			updateMatchesById(userMatches);
		}else {
			System.out.println("El match no existe, se guardará");
			userMatchesRes = userMatchesRepository.save(userMatches);
		}
	    return userMatchesRes;
	}
	
	@GetMapping("/user/matches/{idUser}")
	public List<UserMatches> getMatchesByIdUser(@PathVariable("idUser") Long idUser) {
		List<UserMatches> listUserMatches = new ArrayList<UserMatches>();
		listUserMatches = userMatchesRepository.getAllUserMatches(idUser);
	    return listUserMatches;
	}
	
	@PutMapping("/user/matches/update")
	public UserMatches updateMatchesById(@RequestBody UserMatches userMatches) {
		Integer res = userMatchesRepository.updateUserMatchById(userMatches.getHome_result(), userMatches.getAway_result(), false, userMatches.getIdUser(), userMatches.getIdUserMatches(),userMatches.getName());
	    if (res == 0) {
	    	System.out.println("not updated");
	    }else{
	    	System.out.println("updated");
	    }
		return userMatches;
	}
	
	// ------------------- Static Matches -------------------------------------------
	@PutMapping("/static/matches")
	public StaticMatches updateStaticMatchResult(@RequestBody StaticMatches staticMatches) {
		Integer staticMatchesRes; //To check if it was updated
		
		//User
		User user = new User();
		
		//Determines Result of the match
		String staticMatchResult = determineResult(staticMatches.getHome_result(), staticMatches.getAway_result());
		
		//Update result in static_matches for one match
		staticMatches.setFinished(true);
		staticMatchesRes = staticMatchesRepository.updateStaticMatchResultById(staticMatches.getHome_result(), staticMatches.getAway_result(), staticMatches.getFinished() ,staticMatches.getIdStaticMatches(), staticMatches.getName());
		
		//Get All userMatches with name and id of the match result updated
		ArrayList<UserMatches> listUserMatchesByMatch = new ArrayList<UserMatches>();
		listUserMatchesByMatch = userMatchesRepository.getSameUserMatchForAllUsersByMatchId(staticMatches.getName());
		
		//For-Each to determinate if user adds points
		for (UserMatches userMatches : listUserMatchesByMatch) {
			//Determines userMatch Result
			String userMatchResult = determineResult(userMatches.getHome_result(), userMatches.getAway_result());
			
			//Get user to update TotalScore
			user = userRepository.checkIfUserExist(userMatches.getIdUser());
			
			//Get current totalScore
			Integer newTotalScore = user.getTotalScore();
			
			//Adds 1 point
			if(staticMatchResult.equals(userMatchResult)) {
				newTotalScore++;
			}
			
			//Adds 3 points
			if(userMatches.getHome_result() == staticMatches.getHome_result() 
					&& userMatches.getAway_result() == staticMatches.getAway_result() ) {
				
				newTotalScore += 2;
			}
			
			//Update totalScore
			user.setTotalScore(newTotalScore);
			userRepository.updateUserScore(user.getTotalScore(), user.getIdUser());
			
			//update finished column as "true" for the match o that user
			userMatchesRepository.updateUserMatchById(userMatches.getHome_result(), userMatches.getAway_result(), true, userMatches.getIdUser(), userMatches.getIdUserMatches(), userMatches.getName());
		}
		
		
	    return staticMatches;
	}
	
	// Get Scores of all users
	@GetMapping("/static/matches/getAll")
	public List<StaticMatches> getAllRealScores() {
		ArrayList<StaticMatches> listAllRealScores = new ArrayList<StaticMatches>();
		listAllRealScores = (ArrayList<StaticMatches>) staticMatchesRepository.getAllRealResults();
	    return listAllRealScores;
	}
	
	
	//Function that determines if the match was won by "H"ome team, "A"way team or "Draw"
	public String determineResult(Integer home_result, Integer away_result) {
		String res="X";
		
		if (home_result > away_result) {
			res="H";
		}
		
		if (home_result < away_result) {
			res="A";
		}
		
		if (home_result == away_result) {
			res="D";
		}
		
		return res;
	}
     
}
