# zomen

**This is a Movie Ticket booking system**

## TECH Used 
* Java
* Spring Boot
* MySQL
* JPA/Hibernate
* Rest api

## How to run this application
*Open the project in an editor and run **ZomentumApplication.java***

## Notice
*Make sure that sql server is running and also change the application.properties file with your sql server username and password.*

*Application will run at port 8080(localhost)*

A nice detailed **documentation** of the apis can be found at http://localhost:8080/swagger-ui.html#
I have used [swagger](https://swagger.io/) to prepare this documentation. You can also hit apis using this documentation page.

## Results

**Adding user to table User**
![markdown logo](https://github.com/C0ffeeMachine/zomen/blob/master/img/Selection_006.png)


----
**User Table after adding two users**
----
![markdown logo](https://github.com/C0ffeeMachine/zomen/blob/master/img/Selection_007.png)



**Since there were no users with this specific mobile number thats why ticket was not issued.A user has to be registered to buy tickets.**
![markdown logo](https://github.com/C0ffeeMachine/zomen/blob/master/img/Selection_008.png)

----
----

**Successful registration of ticket**
![markdown logo](https://github.com/C0ffeeMachine/zomen/blob/master/img/Selection_009.png)

----
----

**Since the booking time of movie is in past, therefore it is not a valid ticket**
![markdown logo](https://github.com/C0ffeeMachine/zomen/blob/master/img/Selection_010.png)



**This is an update request to change the movie timing**
![markdown logo](https://github.com/C0ffeeMachine/zomen/blob/master/img/Selection_011.png)



**An endpoint to view all the tickets for a particular time**
![markdown logo](https://github.com/C0ffeeMachine/zomen/blob/master/img/Selection_012.png)



**An endpoint to delete a particular ticket**
![markdown logo](https://github.com/C0ffeeMachine/zomen/blob/master/img/Selection_013.png)



**An endpoint to view the user's details based on the ticket id**
![markdown logo](https://github.com/C0ffeeMachine/zomen/blob/master/img/Selection_014.png)



**I populated the ticket table 20 time using a specific time and hereafter it starts giving exception though the fields are valid, this is because no more than 20 tickets can be booked for a specific time**
![markdown logo](https://github.com/C0ffeeMachine/zomen/blob/master/img/Selection_015.png)



**ticket is not valid if the booking time is in past**
![markdown logo](https://github.com/C0ffeeMachine/zomen/blob/master/img/Selection_016.png)



