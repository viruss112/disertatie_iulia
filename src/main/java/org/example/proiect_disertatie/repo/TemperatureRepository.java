package org.example.proiect_disertatie.repo;

import org.example.proiect_disertatie.domain.entities.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {

  Temperature findTopByOrderByMeasuredOnDesc();
}

