package org.example.proiect_disertatie.repo;

import org.example.proiect_disertatie.domain.entities.Proximity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProximityRepository extends JpaRepository<Proximity, Integer> {

  Proximity findTopByOrderByMeasuredOnDesc();
}

