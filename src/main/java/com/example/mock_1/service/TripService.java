package com.example.mock_1.service;

import com.example.mock_1.entity.BookingOffice;
import com.example.mock_1.entity.Trip;
import com.example.mock_1.exception.NotFoundException;
import com.example.mock_1.repository.BookingOfficeRepository;
import com.example.mock_1.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getAllTrip() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getTrip(int id) {
        return tripRepository.findById(id);
    }

    public Trip addBookingOffice(Trip trip) {
        return tripRepository.save(trip);

    }

    public Trip updateTrip(int id, Trip new_trip) {
        Optional<Trip> old_trip = tripRepository.findById(id);
        if (!old_trip.isPresent()) {
            throw new NotFoundException("Can't update, Trip doesn't exist ");
        }
        new_trip.setTripId(id);
        return tripRepository.save(new_trip);
    }

    public String deleteTrip(int id) {
        Optional<Trip> tripToDelete = tripRepository.findById(id);
        if (!tripToDelete.isPresent()) {
            throw new NotFoundException("It's not have that trip");
        }
        tripRepository.deleteById((Integer) id);
        return "Delete successfully";
    }

    public List<Trip> findTripByDate(LocalDate date){
        return tripRepository.findTripByDate(date);
    }
}
