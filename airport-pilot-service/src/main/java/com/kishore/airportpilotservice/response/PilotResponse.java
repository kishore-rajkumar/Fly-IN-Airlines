package com.kishore.airportpilotservice.response;

import java.io.Serializable;

import com.kishore.airportpilotservice.entity.Pilot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
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

}
