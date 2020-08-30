package com.example.zomentum.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(int id){super("User Details not found"+id);}
}
