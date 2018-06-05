package com.rusia2018.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rusia2018.model.Match;

/**
 * @author Hugo
 * MatchInterface
 */
public interface MatchRepository extends JpaRepository<Match, Serializable> {

}
