package com.example.zomentum.DataAccessLayer;

import org.joda.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    @Query(value = "SELECT t FROM Ticket t WHERE t.mobNumber =:mob")
    Ticket findTicketByMobileNumber(String mob);

    @Query(value = "SELECT t FROM Ticket t WHERE t.movieTime =:timestamp")
    List<Ticket> findAllTicketsByTime(LocalTime timestamp);

    @Query(value = "SELECT t FROM Ticket t WHERE t.status =:st")
    List<Ticket> findByStatus(int st);

    @Query(value = "SELECT t FROM Ticket t WHERE t.bookedDate =:d AND t.movieTime =:m")
    List<Ticket> findCount(LocalDate d, LocalTime m);

}
