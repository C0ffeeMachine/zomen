package com.example.zomentum.DataAccessLayer;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String userName;

    @Column(nullable = false)
    private String mobNumber;


    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate bookedDate;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime movieTime;

    @Column
    private int status;

    public Ticket(String userName, String mobNumber, LocalDate bookedDate, LocalTime movieTime) {
        this.userName = userName;
        this.mobNumber = mobNumber;
        this.bookedDate = bookedDate;
        this.movieTime = movieTime;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    public LocalDate getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(LocalDate bookedDate) {
        this.bookedDate = bookedDate;
    }

    public LocalTime getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(LocalTime movieTime) {
        this.movieTime = movieTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
