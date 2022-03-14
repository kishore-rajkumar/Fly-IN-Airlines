package com.kishore.airportpilotservice.service;

import java.util.List;

import com.kishore.airportpilotservice.response.PilotResponse;

public interface PilotService {

	PilotResponse getPilotById(Long id);

	List<PilotResponse> getAllPilots();

	List<PilotResponse> findPilotsByDesignation(String designation);

}
