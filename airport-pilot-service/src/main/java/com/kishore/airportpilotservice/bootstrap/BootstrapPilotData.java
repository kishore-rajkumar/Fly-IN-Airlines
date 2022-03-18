package com.kishore.airportpilotservice.bootstrap;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kishore.airportpilotservice.entity.Pilot;
import com.kishore.airportpilotservice.repository.PilotRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BootstrapPilotData implements CommandLineRunner {

	@Autowired
	private PilotRepository repository;

	@Override
	public void run(String... args) throws Exception {

		log.info("initializing pilot data ...");
		initializePilotData();

		log.info("pilot data initialized ...");

		loadPilotData();

	}

	private void initializePilotData() {

		Pilot jan = Pilot.builder().name("Sandeep Kumar").designation("Sr. Pilot").experience("12").build();
		repository.save(jan);

		Pilot feb = Pilot.builder().name("Alex James").designation("Sr. Pilot").experience("18").build();
		repository.save(feb);

		Pilot mar = Pilot.builder().name("Rajesh Mishra").designation("Sr. Pilot").experience("15").build();
		repository.save(mar);

		Pilot apr = Pilot.builder().name("Uttam Yadav").designation("Pilot").experience("8").build();
		repository.save(apr);

		Pilot may = Pilot.builder().name("Monty Singh").designation("Pilot").experience("9").build();
		repository.save(may);

	}

	private void loadPilotData() {

		List<Pilot> pilots = repository.findAll();
		pilots.stream().forEach(p -> log.info("Created -> " + p));

	}

}
