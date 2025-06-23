package org.example.proiect_disertatie.service;

import lombok.RequiredArgsConstructor;
import org.example.proiect_disertatie.domain.entities.Light;
import org.example.proiect_disertatie.repo.LightRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LightService {

  private final LightRepository lightRepository;

  public Light getLatestLight() {
    return lightRepository.findTopByOrderByMeasuredOnDesc();
  }

}
