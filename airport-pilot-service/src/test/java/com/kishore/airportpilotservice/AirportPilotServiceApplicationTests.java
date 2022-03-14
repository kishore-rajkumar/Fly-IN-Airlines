package com.kishore.airportpilotservice;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kishore.airportpilotservice.controller.PilotController;

@SpringBootTest
class AirportPilotServiceApplicationTests {
	
	
	@Autowired
	private PilotController pilotController;

	@Test
	void contextLoads() {
		assertThat(pilotController).isNotNull();
	}

}
