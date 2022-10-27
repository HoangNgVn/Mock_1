package com.example.mock_1.repository;

import com.example.mock_1.entity.Ticket;
import com.example.mock_1.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

//  localhost:8080/ticket/inTime?startTime=06:00:00&endTime=13:00:00
    @Query(value = "SELECT * FROM ticket WHERE bookingTime BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Ticket> findTicketByInRangeTime(LocalTime startTime, LocalTime endTime);
}
