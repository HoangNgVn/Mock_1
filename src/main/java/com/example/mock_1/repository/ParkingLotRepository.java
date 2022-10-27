package com.example.mock_1.repository;

import com.example.mock_1.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {

//    localhost:8080/parkingLot/status/blank
    @Query(value = "SELECT * FROM parkinglot WHERE parkStatus= ?1", nativeQuery = true)
    List<ParkingLot> findParkingLotByStatus(String status);
}
