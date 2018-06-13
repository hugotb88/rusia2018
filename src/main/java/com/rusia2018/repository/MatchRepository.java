package com.rusia2018.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rusia2018.model.Match;

/**
 * @author Hugo
 * MatchInterface
 */
public interface MatchRepository extends JpaRepository<Match, Serializable> {

	@Query(value="SELECT * FROM matches",nativeQuery=true)
    public List<Match> getAllMatches();
	
	@Query(value="SELECT * FROM matches m WHERE m.idMatches = :idMatches",nativeQuery=true)
    public Match getMatchById(@Param("idMatches") int idMatches);

}
