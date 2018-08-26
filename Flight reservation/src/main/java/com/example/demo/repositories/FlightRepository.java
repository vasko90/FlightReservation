package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{

	
	@Query("select f from Flight f where f.departure_city=:dcity and f.arrival_city=:acity and f.departure_date=:date")
	List<Flight> findAllFlights(@Param("dcity")String dcity, @Param("acity")String acity, @Param("date")String date);

    @Query("select distinct f.departure_city from Flight f")
    List<Flight> findDepartureCities();
    
    @Query("select distinct f.arrival_city from Flight f")
    List<Flight> findArrivalCities();

}
