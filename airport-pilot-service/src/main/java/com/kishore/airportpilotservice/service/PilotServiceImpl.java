package com.kishore.airportpilotservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kishore.airportpilotservice.entity.Pilot;
import com.kishore.airportpilotservice.repository.PilotRepository;
import com.kishore.airportpilotservice.response.PilotResponse;

@Service
public class PilotServiceImpl implements PilotService {

	@Autowired
	private PilotRepository repository;

	@Override
	public PilotResponse getPilotById(Long id) {
		// improve this with custom exception

		Optional<Pilot> pilotOptional = repository.findById(id);
		if (!pilotOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pilot not found with id: " + id);
		}
		return new PilotResponse(pilotOptional.get());
	}

	@Override
	public List<PilotResponse> getAllPilots() {
		List<Pilot> pilots = repository.findAll();

		List<PilotResponse> responses = new ArrayList<>();

		for (Pilot p : pilots) {
			responses.add(new PilotResponse(p));
		}

		return responses;
	}

	@Override
	public List<PilotResponse> findPilotsByDesignation(String designation) {
		return null;
	}

}
