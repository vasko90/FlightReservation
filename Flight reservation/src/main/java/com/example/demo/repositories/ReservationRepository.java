package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Reservation;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}