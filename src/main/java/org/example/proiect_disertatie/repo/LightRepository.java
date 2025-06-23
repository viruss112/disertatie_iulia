package org.example.proiect_disertatie.repo;

import org.example.proiect_disertatie.domain.entities.Light;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightRepository extends JpaRepository<Light, Integer> {

  Light findTopByOrderByMeasuredOnDesc();

}
