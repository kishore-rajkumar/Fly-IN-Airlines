package com.kishore.airportpilotservice.bootstrap;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kishore.airportpilotservice.entity.Pilot;
import com.kishore.airportpilotservice.repository.PilotRepository;

@Component
public class BootstrapPilotData implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BootstrapPilotData.class);

	@Autowired
	private PilotRepository repository;

	@Override
	public void run(String... args) throws Exception {

		logger.info("initializing pilot data ...");
		initializePilotData();

		logger.info("pilot data initialized ...");

		loadPilotData();

	}

	private void initializePilotData() {

		Pilot jan = new Pilot("Sandeep Kumar", "Sr. Pilot", "12");
		repository.save(jan);
		Pilot feb = new Pilot("Alex James", "Sr. Pilot", "18");
		repository.save(feb);
		Pilot mar = new Pilot("Rajesh Mishra", "Sr. Pilot", "15");
		repository.save(mar);
		Pilot apr = new Pilot("Uttam Yadav", "Pilot", "8");
		repository.save(apr);
		Pilot may = new Pilot("Monty Singh", "Pilot", "9");
		repository.save(may);

	}

	private void loadPilotData() {

		List<Pilot> pilots = repository.findAll();
		pilots.stream().forEach(p -> logger.info("Created -> " + p));

	}

}
