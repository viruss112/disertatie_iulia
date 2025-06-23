package org.example.proiect_disertatie.repo;

import org.example.proiect_disertatie.domain.entities.Humidity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumidityRepository extends JpaRepository<Humidity, Integer> {

  Humidity findTopByOrderByMeasuredOnDesc();

}
