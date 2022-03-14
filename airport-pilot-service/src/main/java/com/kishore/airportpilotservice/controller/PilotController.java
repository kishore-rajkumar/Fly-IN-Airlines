package com.kishore.airportpilotservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.airportpilotservice.response.PilotResponse;
import com.kishore.airportpilotservice.service.PilotService;

@RestController
public class PilotController {

	@Autowired
	private PilotService pilotService;

	/*
	 * A GET API to retrieve an existing pilot
	 * 
	 * @param pilot id
	 * 
	 * @return PilotResponse (id, name, designation, experience)
	 */
	@GetMapping("/api/v1/pilots/{id}")
	public ResponseEntity<PilotResponse> getPilotById(@PathVariable Long id) {
		PilotResponse pilotResponse = pilotService.getPilotById(id);
		return new ResponseEntity<>(pilotResponse, HttpStatus.OK);
	}

	/*
	 * A GET API to retrieve all existing pilots
	 * 
	 * @return List<PilotResponse (id, name, designation, experience)>
	 */
	@GetMapping("/api/v1/pilots")
	public ResponseEntity<List<PilotResponse>> getAllPilots() {
		List<PilotResponse> listPilotResponse = pilotService.getAllPilots();
		return new ResponseEntity<>(listPilotResponse, HttpStatus.OK);
	}
	
	
	/*
	 * A GET API to find existing pilots by designation
	 * 
	 * @param pilot designation
	 * 
	 * @return List<PilotResponse (id, name, designation, experience)>
	 */
	@GetMapping("/api/v1/pilots/find-by-designation")
	public ResponseEntity<List<PilotResponse>> findPilotsByDesignation(@RequestParam String designation) {
		List<PilotResponse> listPilotResponse = pilotService.findPilotsByDesignation(designation);
		return new ResponseEntity<>(listPilotResponse, HttpStatus.FOUND);
	}

}
