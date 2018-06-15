package com.rusia2018.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rusia2018.model.Match;
import com.rusia2018.model.StaticMatches;

/**
 * @author Hugo
 *
 */
public interface StaticMatchesRepository extends JpaRepository<StaticMatches, Serializable> {
	
	@Query(value="SELECT * FROM static_matches",nativeQuery=true)
    public List<Match> getAllMatchesWithResult();
	
	@Query(value="SELECT * FROM static_matches sm WHERE sm.idStaticMatches = :idStaticMatches",nativeQuery=true)
    public Match getMatchById(@Param("idStaticMatches") int idStaticMatches);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE static_matches SET home_result = :home_result, away_result = :away_result, finished = :finished WHERE idStaticMatches = :idStaticMatches AND name = :name",nativeQuery=true)
    public Integer updateStaticMatchResultById(@Param("home_result") Integer home_result, @Param("away_result") Integer away_result, @Param("finished") Boolean finished ,@Param("idStaticMatches") Long idStaticMatches, @Param("name") Integer name);
	
	@Query(value="SELECT * FROM static_matches WHERE home_result IS NOT NULL AND home_result IS NOT NULL;",nativeQuery=true)
    public ArrayList<StaticMatches> getAllRealResults();

}
