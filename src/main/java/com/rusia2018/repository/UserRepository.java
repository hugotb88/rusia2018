package com.rusia2018.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rusia2018.model.User;

/**
 * @author Hugo
 * User Interface
 */
@Repository
public interface UserRepository extends JpaRepository<User,Serializable>{
	
//	@Query(value="SELECT * FROM event e WHERE e.id_event = :id_event",nativeQuery=true)
//    public Event getEventById(@Param("id_event") int id_event);
//	
//	@Query(value="SELECT * FROM event e WHERE e.id_user = :id_user",nativeQuery=true)
//    public List<Event> getEventsByUserId(@Param("id_user") int id_user);
//	
//	@Query(value="SELECT * FROM event ev WHERE ev.date = :date", nativeQuery=true)
//    public List<Event> getEventsByDate(@Param("date") String date);
}
