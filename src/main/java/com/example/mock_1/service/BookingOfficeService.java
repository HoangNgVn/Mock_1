package com.example.mock_1.service;

import com.example.mock_1.entity.BookingOffice;
import com.example.mock_1.exception.NotFoundException;
import com.example.mock_1.repository.BookingOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingOfficeService {
    @Autowired
    private BookingOfficeRepository bookingOfficeRepository;

    public List<BookingOffice> getAllBookingOffice() {
        return bookingOfficeRepository.findAll();
    }

    public Optional<BookingOffice> getBookingOffice(int id) {
        return bookingOfficeRepository.findById(id);
    }

    public BookingOffice addBookingOffice(BookingOffice bookingOffice) {
        return bookingOfficeRepository.save(bookingOffice);
    }

    public BookingOffice updateBookingOffice(int id, BookingOffice bookingOffice) {
        Optional<BookingOffice> office = bookingOfficeRepository.findById(id);
        if (!office.isPresent()) {
            throw new NotFoundException("Can't update, Booking office doesn't exist ");
        }
        bookingOffice.setOfficeId(id);
        return bookingOfficeRepository.save(bookingOffice);
    }

    public String deleteBookingOffice(int id) {
        Optional<BookingOffice> officeToDelete = bookingOfficeRepository.findById(id);
        if (!officeToDelete.isPresent()) {
            throw new NotFoundException("It's not have that Booking office");
        }
        bookingOfficeRepository.deleteById((Integer) id);
        return "Delete successfully";
    }

    public List<BookingOffice> findBookingOfficeByRangeTime(LocalDate startTime, LocalDate endTime){
        return bookingOfficeRepository.findBookingOfficeByRangeTime(startTime, endTime);
    }
}
