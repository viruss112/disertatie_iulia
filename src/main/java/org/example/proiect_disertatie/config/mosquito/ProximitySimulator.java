package org.example.proiect_disertatie.config.mosquito;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.example.proiect_disertatie.domain.entities.Proximity;
import org.example.proiect_disertatie.domain.enums.Location;
import org.example.proiect_disertatie.repo.ProximityRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProximitySimulator {

  private final Random random = new Random();
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
  private final ProximityRepository proximityRepository;

  public void startSimulatingProximity() {
    scheduler.scheduleAtFixedRate(() -> {
      int proximity = random.nextInt(2); // Generate random proximity: 0 or 1

      var proximitySensor = new Proximity()
          .setUnitOfMeasure("binary")
          .setValue((double) proximity)
          .setLocation(getRandomLocation())
          .setMeasuredOn(Instant.now());

      proximityRepository.save(proximitySensor);
    }, 0, 5, TimeUnit.SECONDS); // Generate every 5 seconds
  }
  private Location getRandomLocation() {
    var locations = Location.values();
    return locations[random.nextInt(locations.length)];
  }
}
