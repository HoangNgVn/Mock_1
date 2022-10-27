package com.example.mock_1.repository;

import com.example.mock_1.entity.BookingOffice;
import com.example.mock_1.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {

    // localhost:8080/trip/inDay?date=2022-10-28
    @Query(value = "SELECT * FROM trip WHERE departureDate=?1", nativeQuery = true)
    List<Trip> findTripByDate(LocalDate date);
}
