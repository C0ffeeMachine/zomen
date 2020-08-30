package com.example.zomentum.DataAccessLayer;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDateTime;

import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class TicketUpdate {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate bookedDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime movieTime;

    public TicketUpdate(LocalDate bookedDate, LocalTime movieTime) {
        this.bookedDate = bookedDate;
        this.movieTime = movieTime;
    }

    public TicketUpdate() {
    }

    public LocalDate getBookedDate() {
        return bookedDate;
    }

    public LocalTime getMovieTime() {
        return movieTime;
    }
}
