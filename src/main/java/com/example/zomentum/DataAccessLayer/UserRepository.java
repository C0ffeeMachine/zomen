package com.example.zomentum.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.mobNumber =:mob")
    User findUserByMobileNumber(String mob);
}
