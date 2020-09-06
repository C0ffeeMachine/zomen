package com.example.zomentum.Controller;

import com.example.zomentum.DataAccessLayer.*;
import com.example.zomentum.Exception.TicketNotFoundException;
import com.example.zomentum.Exception.TicketNotValidException;
import com.example.zomentum.Exception.UserNotFoundException;
import com.example.zomentum.Util.DateTimeFormat;
import com.example.zomentum.Util.TicketValidator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class TicketResource {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    TicketValidator validator = new TicketValidator();

    DateTimeFormat dateTimeFormat;

    @GetMapping("/tickets/mt/{bookedDate}/{movieTime}")
    @ApiOperation(value = "An endpoint to view all the tickets for a particular time.")
    List<Ticket> findAll(@PathVariable String bookedDate,@PathVariable String movieTime){
        LocalTime lt = LocalTime.parse(movieTime);
        LocalDate ld = LocalDate.parse(bookedDate);
        return ticketRepository.findCount(ld,lt);
    }

    @GetMapping("/tickets/{id}/user")
    @ApiOperation(value = "An endpoint to view the user's details based on the ticket id.")
    User findUserDetail(@PathVariable int id){
        Ticket t = ticketRepository.findById(id).orElseThrow(()-> new TicketNotFoundException(id));
        User u = userRepository.findUserByMobileNumber(t.getMobNumber());
        return u;
    }

    @GetMapping(value = "/tickets/{id}")
    @ApiOperation(value = "Get ticket by id")
    Ticket getTicketById(@PathVariable int id){
        return ticketRepository.findById(id).orElseThrow(()-> new TicketNotFoundException(id));
    }

    @GetMapping(value = "/tickets")
    @ApiOperation(value = "Get all tickets")
    List<Ticket> findTickets(){
        return ticketRepository.findAll();
    }

    @PostMapping(value = "/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "An endpoint to book a ticket using a user's name, phone number, and timings.")
    Ticket newTicket(@RequestBody Ticket ticket) throws ParseException {

        List<Ticket> cn = ticketRepository.findCount(ticket.getBookedDate(),ticket.getMovieTime());
        int count;
        if (cn==null)
            count =0;
        count = cn.size();

        List<Ticket> list = ticketRepository.findAll();
        for(Ticket ty:list){
            validator.markTicketInvalid(ty);
        }

        List<Ticket> dt = ticketRepository.findByStatus(0);
        for(Ticket te:dt){
            ticketRepository.deleteById(te.getId());
        }
        User u = userRepository.findUserByMobileNumber(ticket.getMobNumber());
        if(u==null) {
            logger.severe("Register First");
            throw new UserNotFoundException(0);
        }

        if(validator.isValid(ticket) && count<=20 && u!=null) {
            return ticketRepository.save(ticket);
        }
        else {
            logger.severe("Ticket not valid");
            throw new TicketNotValidException();
        }

    }

    @PutMapping("/tickets/{id}")
    @ApiOperation(value = "An endpoint to update a ticket timing based on ticket id.")
    Ticket updateTicket(@PathVariable int id, @RequestBody TicketUpdate ticketUpdate) throws Exception {
        Ticket t = ticketRepository.findById(id).orElseThrow(()-> new TicketNotFoundException(id));
        t.setBookedDate(ticketUpdate.getBookedDate());
        t.setMovieTime(ticketUpdate.getMovieTime());
        return ticketRepository.save(t);
    }

    @DeleteMapping(value = "/tickets/{id}")
    @ApiOperation(value = "An endpoint to delete a particular ticket based on ticket id.")
    void deleteTicket(@PathVariable(value = "id") int id){
        ticketRepository.deleteById(id);
    }
}
