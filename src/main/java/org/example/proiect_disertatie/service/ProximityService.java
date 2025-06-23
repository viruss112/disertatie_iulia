package org.example.proiect_disertatie.service;

import lombok.RequiredArgsConstructor;
import org.example.proiect_disertatie.domain.entities.Proximity;
import org.example.proiect_disertatie.repo.ProximityRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProximityService {

  private final ProximityRepository proximityRepository;

  public Proximity getLatestProximity() {
    return proximityRepository.findTopByOrderByMeasuredOnDesc();
  }

}
