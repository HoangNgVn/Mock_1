package com.example.mock_1.repository;

import com.example.mock_1.entity.BookingOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Integer> {

//    localhost:8080/bookingOffice/date?startDate=2022-10-26&endDate=2022-10-30
    @Query(value = "SELECT * FROM bookingoffice WHERE startContractDeadline BETWEEN ?1 AND ?2", nativeQuery = true)
    List<BookingOffice> findBookingOfficeByRangeTime(LocalDate startTime, LocalDate endTime);
}
