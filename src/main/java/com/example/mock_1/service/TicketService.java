package com.example.mock_1.service;


import com.example.mock_1.entity.Ticket;
import com.example.mock_1.exception.NotFoundException;
import com.example.mock_1.repository.TicketRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicket(int id) {
        return ticketRepository.findById(id);
    }

    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);

    }

    public Ticket updateTicket(int id, Ticket new_ticket) {
        Optional<Ticket> old_ticket = ticketRepository.findById(id);
        if (!old_ticket.isPresent()) {
            throw new NotFoundException("Can't update, Ticket doesn't exist ");
        }
        new_ticket.setTicketId(id);
        return ticketRepository.save(new_ticket);
    }

    public String deleteTicket(int id) {
        Optional<Ticket> ticketToDelete = ticketRepository.findById(id);
        if (!ticketToDelete.isPresent()) {
            throw new NotFoundException("It's not have that ticket");
        }
        ticketRepository.deleteById((Integer) id);
        return "Delete successfully";
    }

    public List<Ticket> findTicketByInRangeTime(LocalTime startTime, LocalTime endTime){
        return ticketRepository.findTicketByInRangeTime(startTime, endTime);
    }
}

