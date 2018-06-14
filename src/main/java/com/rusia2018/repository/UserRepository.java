package com.rusia2018.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rusia2018.model.User;

/**
 * @author Hugo
 * User Interface
 */
@Repository
public interface UserRepository extends JpaRepository<User,Serializable>{
	
	@Query(value="SELECT * FROM users u WHERE u.idUser = :idUser",nativeQuery=true)
    public User checkIfUserExist(@Param("idUser") Long idUser);
	
	@Query(value="SELECT * FROM users",nativeQuery=true)
    public List<User> getScoresOfAll();
	
	@Transactional
	@Modifying
	@Query(value="UPDATE users SET totalScore = :totalScore WHERE idUser = :idUser",nativeQuery=true)
    public Integer updateUserScore(@Param("totalScore") Integer totalScore, @Param("idUser") Long idUser);
//	
//	@Query(value="SELECT * FROM event e WHERE e.id_user = :id_user",nativeQuery=true)
//    public List<Event> getEventsByUserId(@Param("id_user") int id_user);
//	
//	@Query(value="SELECT * FROM event ev WHERE ev.date = :date", nativeQuery=true)
//    public List<Event> getEventsByDate(@Param("date") String date);
}
