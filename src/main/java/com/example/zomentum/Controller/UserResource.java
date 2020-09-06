package com.example.zomentum.Controller;

import com.example.zomentum.DataAccessLayer.User;
import com.example.zomentum.DataAccessLayer.UserRepository;
import com.example.zomentum.Exception.UserNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
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

    @GetMapping(value = "/users")
    @ApiOperation(value = "Returns a list of users")
    List<User> getUsers(){
        return repository.findAll();
    }

    @GetMapping(value = "/users/{id}")
    @ApiOperation(value = "Get user by id")
    User getUser(@PathVariable int id){
        return repository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @GetMapping(value = "/users/info/{mobNumber}")
    @ApiOperation(value = "Get user by mobile number")
    User getUserByMobileNumber(@PathVariable String mobNumber){
        return repository.findUserByMobileNumber(mobNumber);
    }

    @PutMapping(value = "/users/{id}")
    @ApiOperation(value = "Update a user based on id")
    User updateUser(@PathVariable int id, @RequestBody User user){
        return repository.save(user);
    }

    @DeleteMapping(value = "/users/{id}")
    @ApiOperation(value = "Delete a User")
    void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }
}
