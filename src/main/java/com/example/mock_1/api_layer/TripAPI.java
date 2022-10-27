package com.example.mock_1.api_layer;

import com.example.mock_1.entity.Trip;
import com.example.mock_1.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "trip")
public class TripAPI {
    @Autowired
    private TripService tripService;

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrip();
    }

    @GetMapping(path = "{tripId}")
    public Optional<Trip> getTripById(@PathVariable("tripId") int id) {
        return tripService.getTrip(id);
    }

    @GetMapping(path = "inDay")
    public List<Trip> getTripByDate(@RequestParam("date")
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                            LocalDate date) {
        return tripService.findTripByDate(date);
    }

    @PostMapping
    public ResponseEntity<Trip> addTrip(@RequestBody @Valid Trip trip) {
        return new ResponseEntity<Trip>(tripService.addBookingOffice(trip), HttpStatus.CREATED);
    }

    @PutMapping(path = "{tripId}")
    public ResponseEntity<Trip> updateTrip(@PathVariable("tripId") int id, @RequestBody @Valid Trip trip) {
        return new ResponseEntity<>(tripService.updateTrip(id, trip), HttpStatus.OK);
    }

    @DeleteMapping(path = "{tripId}")
    public String deleteTrip(@PathVariable("tripId") int id) {
        return tripService.deleteTrip(id);
    }
}
