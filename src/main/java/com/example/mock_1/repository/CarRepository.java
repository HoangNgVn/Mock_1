package com.example.mock_1.repository;

import com.example.mock_1.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, String> {

    Optional<Car> findByLicensePlate(String license);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM car WHERE licensePlate = ?1", nativeQuery = true)
    void deleteByLicensePlate(String license);
}
