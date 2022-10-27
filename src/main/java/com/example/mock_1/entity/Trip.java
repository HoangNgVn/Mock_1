package com.example.mock_1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripId;

    @Min(value = 0, message = "bookedTicketNumber must not be negative")
    private int bookedTicketNumber;

    private String carType;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private String destination;
    private String driver;

    @Positive(message = "maximumOnlineTicketNumber must be positive")
    private int maximumOnlineTicketNumber;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BookingOffice> bookingOffices;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> tickets;

    public int getTripId() {
        return tripId;
    }

    public int getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public String getCarType() {
        return carType;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public String getDriver() {
        return driver;
    }

    public int getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setBookedTicketNumber(int bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    public List<BookingOffice> getBookingOffices() {
        return bookingOffices;
    }

    public void setBookingOffices(List<BookingOffice> bookingOffices) {
        this.bookingOffices = bookingOffices;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
