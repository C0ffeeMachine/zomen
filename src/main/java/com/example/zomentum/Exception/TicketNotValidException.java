package com.example.zomentum.Exception;

public class TicketNotValidException extends RuntimeException{
    public TicketNotValidException(){super("Ticket details not valid");}
}
