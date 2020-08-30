package com.example.zomentum.Exception;

public class TicketNotFoundException extends RuntimeException{
    public TicketNotFoundException(int id){super("No Ticket found with id"+id);}
}
