package com.rusia2018.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rusia2018.model.Team;
import com.rusia2018.model.User;

/**
 * @author Hugo
 * Team Repository
 */
public interface TeamRepository extends JpaRepository<Team, Serializable>{
	
	@Query(value="SELECT * FROM teams",nativeQuery=true)
    public List<Team> getAllTeams();
	
	@Query(value="SELECT * FROM teams t WHERE t.id = :id",nativeQuery=true)
    public Team getTeamById(@Param("id") int id);

}
