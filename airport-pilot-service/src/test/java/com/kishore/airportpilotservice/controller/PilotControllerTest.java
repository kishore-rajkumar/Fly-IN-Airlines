package com.kishore.airportpilotservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.kishore.airportpilotservice.AirportPilotServiceApplication;
import com.kishore.airportpilotservice.service.PilotService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AirportPilotServiceApplication.class })
@WebMvcTest(value = PilotController.class)
public class PilotControllerTest {
	
	/* 
	 * @WebMvcTest annotation can be used for a Spring MVC test that focuses <strong>only</strong> on Spring MVC components.
	 * 
	 * We have plan to test only PilotController (Only isolated component and NOT the other layers such as service, repository)
	 * 
	 * The PilotController is dependent on PilotService & PilotRepository So to test PilotController we need to mock the PilotService & PilotRepository objects 
	 * 
	 * Mocking is nothing but creating a dummy object 
	 * 
	 * @MockBean annotation is used to create a mock object
	 * 
	 * MockMvc is used to send a request for our RestController
	 */
	
	@MockBean
	PilotService service;
	
	@Autowired
	private MockMvc mockMvc;
	

	/* Testing the @RestController GET method */
	
	@Test
	void testGetPilotById() throws Exception{
		when(service.getPilotById(ArgumentMatchers.any()))
		.thenReturn(ArgumentMatchers.any());
		
		/* dummy request pilot id */
		long pilotId = 1;
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/pilots/" + pilotId);
		
		MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		
		assertEquals(200, status);
		
	}

}
