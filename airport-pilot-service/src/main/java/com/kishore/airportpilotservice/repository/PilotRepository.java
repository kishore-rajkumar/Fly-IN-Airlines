package com.kishore.airportpilotservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kishore.airportpilotservice.entity.Pilot;

public interface PilotRepository extends JpaRepository<Pilot, Long> {

}
