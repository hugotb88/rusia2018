package com.rusia2018.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rusia2018.model.UserMatches;

/**
 * @author Hugo
 * UserMatches Interface
 */
public interface UserMatchesRepository extends JpaRepository<UserMatches, Serializable> {
	
	@Query(value="SELECT * FROM user_matches um WHERE um.idUser = :idUser AND name = :name",nativeQuery=true)
    public UserMatches checkIfUserMatchesExist(@Param("idUser") Long idUser, @Param("name") Integer name);
	
	@Query(value="SELECT * FROM user_matches um WHERE um.idUser = :idUser",nativeQuery=true)
    public List<UserMatches> getAllUserMatches(@Param("idUser") Long idUser);
	
	@Query(value="SELECT um.idUserMatches, m.away_result, m.away_team, m.date, m.home_result, m.home_team, um.idUser, um.matchday, m.name, m.type FROM matches m LEFT JOIN user_matches um ON m.name = um.name AND um.idUser = :idUser",nativeQuery=true)
    public ArrayList<UserMatches> getAllUserMatchesByUser(@Param("idUser") Long idUser);
	
	@Query(value="SELECT * FROM user_matches um WHERE um.name = :name",nativeQuery=true)
    public ArrayList<UserMatches> getSameUserMatchForAllUsersByMatchId(@Param("name") Integer name);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE user_matches SET home_result = :home_result, away_result = :away_result, finished = :finished WHERE idUser = :idUser AND idUserMatches = :idUserMatches AND name = :name",nativeQuery=true)
    public Integer updateUserMatchById(@Param("home_result") Integer home_result, @Param("away_result") Integer away_result, @Param("finished") Boolean finished, @Param("idUser") Long idUser, @Param("idUserMatches") Long idUserMatches, @Param("name") Integer name);
	
	@Query(value="SELECT * FROM user_matches um WHERE um.idUser = :idUser AND finished = 1",nativeQuery=true)
    public List<UserMatches> getFinishedMatchesByUser(@Param("idUser") Long idUser);
	
}
