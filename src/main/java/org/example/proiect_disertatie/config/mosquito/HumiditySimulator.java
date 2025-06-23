package org.example.proiect_disertatie.config.mosquito;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.example.proiect_disertatie.domain.entities.Humidity;
import org.example.proiect_disertatie.domain.enums.Location;
import org.example.proiect_disertatie.repo.HumidityRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HumiditySimulator {

  private final Random random = new Random();
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
  private final HumidityRepository humidityRepository;

  public void startSimulatingHumidity() {
    scheduler.scheduleAtFixedRate(() -> {
      double humidity =
          20 + (30 * random.nextDouble()); // Generate random humidity between 30% and 60%

      var humiditySensor = new Humidity()
          .setUnitOfMeasure("percentage(%)")
          .setValue(humidity)
          .setLocation(getRandomLocation())
          .setMeasuredOn(Instant.now());

      humidityRepository.save(humiditySensor);
    }, 0, 5, TimeUnit.SECONDS);
  }

  private Location getRandomLocation() {
    var locations = Location.values();
    var random = new Random();
    return locations[random.nextInt(locations.length)];
  }
}