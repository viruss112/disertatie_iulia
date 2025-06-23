package org.example.proiect_disertatie.config.mosquito;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.example.proiect_disertatie.domain.entities.Light;
import org.example.proiect_disertatie.domain.enums.Location;
import org.example.proiect_disertatie.repo.LightRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LightSimulator {

  private final Random random = new Random();
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
  private final LightRepository lightRepository;


  public void startSimulatingLight() {
    scheduler.scheduleAtFixedRate(() -> {
      double luminosity = 100 + (900 * random.nextDouble()); // Generate random luminosity between 100 and 1000 lux

      var lightSensor = new Light()
          .setUnitOfMeasure("lux")
          .setValue(luminosity)
          .setLocation(getRandomLocation())
          .setMeasuredOn(Instant.now());

      lightRepository.save(lightSensor);
    }, 0, 5, TimeUnit.SECONDS);
  }

  private Location getRandomLocation() {
    var locations = Location.values();
    return locations[random.nextInt(locations.length)];
  }
}