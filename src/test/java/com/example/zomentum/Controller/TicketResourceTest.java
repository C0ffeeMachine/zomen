package com.example.zomentum.Controller;

import com.example.zomentum.DataAccessLayer.Ticket;
import com.example.zomentum.DataAccessLayer.TicketRepository;
import com.example.zomentum.DataAccessLayer.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TicketResource.class)
class TicketResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TicketRepository ticketRepository;

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private TicketResource ticketResource;

    @Test
    void findAll() throws Exception {

        Ticket ticket = new Ticket("jojo","7363636", LocalDate.parse("2020-09-04"), LocalTime.parse("21:10:00"));
        Ticket ticket1 = new Ticket("ojo","7363636", LocalDate.parse("2020-09-04"), LocalTime.parse("21:10:00"));

        LocalTime lt = LocalTime.parse("21:10:00");
        LocalDate ld = LocalDate.parse("2020-09-04");

        given(ticketRepository.findCount(ld,lt)).willReturn(Arrays.asList(ticket,ticket1));

        MockHttpServletResponse response = mvc.perform(
                get("/tickets/mt/2020-09-04/21:10:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userName").value("jojo"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

//    @Test
//    void findUserDetail() {
//    }
//
    @Test
    void newTicket() throws Exception {
        Ticket ticket = new Ticket("jojo","7363636", LocalDate.parse("2020-09-04"), LocalTime.parse("21:10:00"));
        given(ticketRepository.save(ticket)).willReturn(ticket);

        MockHttpServletResponse response = mvc.perform(
                post("/tickets")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("jojo"))
                .andDo(print())
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    
//
//    @Test
//    void updateTicket() {
//    }
//
//    @Test
//    void deleteTicket() {
//    }
}