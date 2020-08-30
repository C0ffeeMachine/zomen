package com.example.zomentum.Util;

import com.example.zomentum.DataAccessLayer.Ticket;
import com.example.zomentum.DataAccessLayer.TicketRepository;
import com.example.zomentum.DataAccessLayer.User;
import com.example.zomentum.DataAccessLayer.UserRepository;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


public class TicketValidator {

    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public boolean isValid(Ticket ticket) throws ParseException {
        int flag=1;
        LocalTime time = ticket.getMovieTime();
        LocalDate date = ticket.getBookedDate();

        LocalDate cd =LocalDate.now();
        LocalTime ct =LocalTime.now();

        if(date.isBefore(cd))
            flag=0;
        else if(date.isEqual(cd)){
            if(time.isBefore(ct))
                flag=0;
        }

        String timestamp = date.toString() + " " + time.toString() + ":00";
        Date d1 = DATE_TIME_FORMAT.parse(timestamp);
        DateTime dt1 = new DateTime(d1);

        LocalDateTime currentDateAndTime = LocalDateTime.now();
        DateTime dt2 = currentDateAndTime.toDateTime();


        //(Hours.hoursBetween(dt1,dt2).getHours()>=8) &&
        if(dt2.isBefore(dt1)){
            ticket.setStatus(1);
            return true;
        }
        else if(dt2.isAfter(dt1)){
            ticket.setStatus(0);
            return false;
        }
        ticket.setStatus(1);
        return true;
    }

    public void markTicketInvalid(Ticket ticket) throws ParseException {
        LocalTime time = ticket.getMovieTime();
        LocalDate date = ticket.getBookedDate();

        String timestamp = date.toString() + " " + time.toString() + ":00";
        Date d1 = DATE_TIME_FORMAT.parse(timestamp);
        DateTime dt1 = new DateTime(d1);

        LocalDateTime currentDateAndTime = LocalDateTime.now();
        DateTime dt2 = currentDateAndTime.toDateTime();

        if(dt2.isAfter(dt1) && (Hours.hoursBetween(dt1,dt2).getHours()>=8)){
            ticket.setStatus(0);
        }
    }
}
