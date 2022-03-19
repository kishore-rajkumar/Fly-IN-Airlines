package com.kishore.airportpilotservice.mapstruct.mapper;

import org.mapstruct.Mapper;

import com.kishore.airportpilotservice.dto.PilotDTO;
import com.kishore.airportpilotservice.entity.Pilot;

//@Mapper(componentModel = "spring") 
// The above configuration is not required if maven plugin compiler args in pom.xml

@Mapper
public interface PilotMapstructMapper {

	public PilotDTO pilotEntityToPilotDto(Pilot entity);

	public Pilot pilotDtoToPilotEntity(PilotDTO dto);

}
