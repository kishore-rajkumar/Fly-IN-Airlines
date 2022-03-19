package com.kishore.airportpilotservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kishore.airportpilotservice.dto.PilotDTO;
import com.kishore.airportpilotservice.entity.Pilot;
import com.kishore.airportpilotservice.mapstruct.mapper.PilotMapstructMapper;
import com.kishore.airportpilotservice.repository.PilotRepository;

@Service
public class PilotServiceImpl implements PilotService {

	@Autowired
	private PilotRepository repository;

	@Autowired
	private PilotMapstructMapper mapper;

	@Override
	public PilotDTO getPilotById(Long id) {
		// improve this with custom exception

		Optional<Pilot> pilotOptional = repository.findById(id);
		if (!pilotOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pilot not found with id: " + id);
		}

		PilotDTO dto = mapper.pilotEntityToPilotDto(pilotOptional.get());

		return dto;
	}

	@Override
	public List<PilotDTO> getAllPilots() {
		List<Pilot> pilots = repository.findAll();

		List<PilotDTO> responses = pilots.stream().map(mapper::pilotEntityToPilotDto).collect(Collectors.toList());

		return responses;
	}

	@Override
	public List<PilotDTO> findPilotsByDesignation(String designation) {
		return null;
	}

}
