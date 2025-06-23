package org.example.proiect_disertatie.config.mosquito;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.example.proiect_disertatie.domain.entities.Temperature;
import org.example.proiect_disertatie.domain.enums.Location;
import org.example.proiect_disertatie.repo.TemperatureRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TemperatureSimulator {

  private final Random random = new Random();
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
  private final TemperatureRepository temperatureRepository;

  public void startSimulatingTemperature() {
    scheduler.scheduleAtFixedRate(() -> {
      double temperature =
          25 + (4 * random.nextDouble()); // Generate random temperature between 25°C and 29°C

      var roomTemperatureSensor = new Temperature()
          .setUnitOfMeasure("°C")
          .setValue(temperature)
          .setLocation(getRandomLocation())
          .setMeasuredOn(Instant.now());

      temperatureRepository.save(roomTemperatureSensor);
    }, 0, 5, TimeUnit.SECONDS); // Generate every 5 seconds
  }

  private Location getRandomLocation() {
    var locations = Location.values();
    return locations[random.nextInt(locations.length)];
  }
}