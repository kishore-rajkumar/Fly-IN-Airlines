package com.kishore.airportpilotservice.service;

import java.util.List;

import com.kishore.airportpilotservice.dto.PilotDTO;

public interface PilotService {

	PilotDTO getPilotById(Long id);

	List<PilotDTO> getAllPilots();

	List<PilotDTO> findPilotsByDesignation(String designation);

}
