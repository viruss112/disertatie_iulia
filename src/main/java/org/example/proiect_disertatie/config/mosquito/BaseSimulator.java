package org.example.proiect_disertatie.config.mosquito;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BaseSimulator {

  private final HumiditySimulator humiditySimulator;
  private final TemperatureSimulator temperatureSensorSimulator;
  private final ProximitySimulator proximitySimulator;
  private final LightSimulator lightSimulator;

  @PostConstruct
  private void startSimulation() {
    humiditySimulator.startSimulatingHumidity();
    temperatureSensorSimulator.startSimulatingTemperature();
    proximitySimulator.startSimulatingProximity();
    lightSimulator.startSimulatingLight();
  }

}
