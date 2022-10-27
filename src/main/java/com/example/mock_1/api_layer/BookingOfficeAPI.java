package com.example.mock_1.api_layer;

import com.example.mock_1.entity.BookingOffice;
import com.example.mock_1.service.BookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "bookingOffice")
public class BookingOfficeAPI {
    @Autowired
    private BookingOfficeService bookingOfficeServiceService;

    @GetMapping
    public List<BookingOffice> getBookingOffices() {
        return bookingOfficeServiceService.getAllBookingOffice();
    }

    @GetMapping(path = "{officeId}")
    public Optional<BookingOffice> getBookingOfficeById(@PathVariable("officeId") int id) {
        return bookingOfficeServiceService.getBookingOffice(id);
    }

    @GetMapping(path = "date")
    public List<BookingOffice> findBookingOfficeByRangeTime(@RequestParam("startDate")
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                    LocalDate startDate,
                                                            @RequestParam("endDate")
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                    LocalDate endDate) {
        return bookingOfficeServiceService.findBookingOfficeByRangeTime(startDate, endDate);
    }

    @PostMapping
    public ResponseEntity<BookingOffice> addOffice(@RequestBody @Valid BookingOffice bookingOffice) {
        return new ResponseEntity<BookingOffice>(bookingOfficeServiceService.addBookingOffice(bookingOffice), HttpStatus.CREATED);
    }

    @PutMapping(path = "{officeId}")
    public ResponseEntity<BookingOffice> updateBookingOffice(@PathVariable("officeId") int id, @RequestBody @Valid BookingOffice bookingOffice) {
        return new ResponseEntity<>(bookingOfficeServiceService.updateBookingOffice(id, bookingOffice), HttpStatus.OK);
    }

    @DeleteMapping(path = "{officeId}")
    public String deleteBookingOffice(@PathVariable("officeId") int id) {
        return bookingOfficeServiceService.deleteBookingOffice(id);
    }
}
