package com.example.mock_1.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalTime;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    private LocalTime bookingTime;

    @NotBlank(message = "customerName must not be blank")
    private String customerName;


    @ManyToOne
    @JoinColumn(name = "licensePlate")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip trip;


    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
