package com.example.mock_1.api_layer;

import com.example.mock_1.entity.Ticket;
import com.example.mock_1.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "ticket")
public class TicketAPI {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTicket();
    }

    @GetMapping(path = "{ticketId}")
    public Optional<Ticket> getTicketById(@PathVariable("ticketId") int id) {
        return ticketService.getTicket(id);
    }

    @GetMapping(path = "inTime")
    public List<Ticket> findTicketByRangeTime(@RequestParam("startTime")
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
                                                      LocalTime startTime,
                                              @RequestParam("endTime")
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
                                                      LocalTime endTime) {
        return ticketService.findTicketByInRangeTime(startTime, endTime);
    }

    @PostMapping
    public ResponseEntity<Ticket> addTicket(@RequestBody @Valid Ticket ticket) {
        return new ResponseEntity<>(ticketService.addTicket(ticket), HttpStatus.CREATED);
    }

    @PutMapping(path = "{ticketId}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable("ticketId") int id, @RequestBody @Valid Ticket ticket) {
        return new ResponseEntity<>(ticketService.updateTicket(id, ticket), HttpStatus.OK);
    }

    @DeleteMapping(path = "{ticketId}")
    public String deleteTicket(@PathVariable("ticketId") int id) {
        return ticketService.deleteTicket(id);
    }

}
