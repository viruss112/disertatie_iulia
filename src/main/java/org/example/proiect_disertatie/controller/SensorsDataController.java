package org.example.proiect_disertatie.controller;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.proiect_disertatie.service.HumidityService;
import org.example.proiect_disertatie.service.LightService;
import org.example.proiect_disertatie.service.ProximityService;
import org.example.proiect_disertatie.service.TemperatureService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SensorsDataController {

  private final SimpMessagingTemplate messagingTemplate;
  private final HumidityService humidityService;
  private final TemperatureService temperatureService;
  private final ProximityService proximityService;
  private final LightService lightService;

  @Scheduled(fixedRate = 5000) // Runs every 5 seconds
  public void sendHumidityData() {
    var latestHumidity = humidityService.getLatestHumidity();
    log.info("Sending humidity data with id: {}", latestHumidity.getId());
    messagingTemplate.convertAndSend("/topic/humidity", Map.of("humidity", latestHumidity));
  }

  @Scheduled(fixedRate = 5000) // Runs every 5 seconds
  public void sendTemperatureData() {
    var latestTemperature = temperatureService.getLatestTemperature();
    log.info("Sending temperature data with id: {}", latestTemperature.getId());
    messagingTemplate.convertAndSend("/topic/temperature", Map.of("temperature", latestTemperature));
  }

  @Scheduled(fixedRate = 5000) // Runs every 5 seconds
  public void sendProximityData() {
    var latestProximity = proximityService.getLatestProximity();
    log.info("Sending proximity data with id: {}", latestProximity.getId());
    messagingTemplate.convertAndSend("/topic/proximity", Map.of("proximity", latestProximity));
  }

  @Scheduled(fixedRate = 5000) // Runs every 5 seconds
  public void sendLightData() {
    var latestLight = lightService.getLatestLight();
    log.info("Sending light data with id: {}", latestLight.getId());
    messagingTemplate.convertAndSend("/topic/light", Map.of("light", latestLight));
  }
}
