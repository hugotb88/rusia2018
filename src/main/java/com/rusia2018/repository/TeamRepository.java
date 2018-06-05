package com.rusia2018.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rusia2018.model.Team;

/**
 * @author Hugo
 * Team Repository
 */
public interface TeamRepository extends JpaRepository<Team, Serializable>{

}
