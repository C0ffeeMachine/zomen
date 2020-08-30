package com.example.zomentum.Controller;

import com.example.zomentum.DataAccessLayer.User;
import com.example.zomentum.DataAccessLayer.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @Autowired
    private UserRepository repository;

    @PostMapping(value = "/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add a user to the User database")
    User newUser(@RequestBody User newUser){
        return repository.save(newUser);
    }
}
