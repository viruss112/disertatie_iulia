package org.example.proiect_disertatie.mapper;

import java.time.Instant;
import org.example.proiect_disertatie.domain.dto.request.HumidityCreateDto;
import org.example.proiect_disertatie.domain.entities.Humidity;
import org.example.proiect_disertatie.domain.enums.Location;

public class HumidityMapper {

  public static Humidity toEntity(HumidityCreateDto dto) {
    return new Humidity()
        .setUnitOfMeasure(dto.getUnitOfMeasure())
        .setValue(dto.getValue())
        .setLocation(Location.valueOf(dto.getLocation().toUpperCase()))
        .setMeasuredOn(Instant.parse(dto.getMeasuredOn()));
  }

}
