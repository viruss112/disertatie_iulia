package org.example.proiect_disertatie.service;

import lombok.RequiredArgsConstructor;
import org.example.proiect_disertatie.domain.entities.Temperature;
import org.example.proiect_disertatie.repo.TemperatureRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemperatureService {

  private final TemperatureRepository temperatureRepository;

  public Temperature getLatestTemperature() {
    return temperatureRepository.findTopByOrderByMeasuredOnDesc();
  }

}
