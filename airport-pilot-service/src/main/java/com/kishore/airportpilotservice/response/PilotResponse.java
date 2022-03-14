package com.kishore.airportpilotservice.response;

import java.io.Serializable;

import com.kishore.airportpilotservice.entity.Pilot;

public class PilotResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String designation;
	private String experience;

	public PilotResponse(Pilot pilotEntity) {
		this.id = pilotEntity.getId();
		this.name = pilotEntity.getName();
		this.designation = pilotEntity.getDesignation();
		this.experience = pilotEntity.getExperience();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "PilotResponse [id=" + id + ", name=" + name + ", designation=" + designation + ", experience="
				+ experience + "]";
	}

}
