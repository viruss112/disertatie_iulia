package org.example.proiect_disertatie.controller;

import lombok.RequiredArgsConstructor;
import org.example.proiect_disertatie.domain.dto.request.HumidityCreateDto;
import org.example.proiect_disertatie.domain.dto.request.HumidityUpdateDto;
import org.example.proiect_disertatie.domain.entities.Humidity;
import org.example.proiect_disertatie.service.HumidityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/humidity")
@RequiredArgsConstructor
public class HumidityController {

  private final HumidityService humidityService;

  @PostMapping("/create")
  public ResponseEntity<Humidity> createHumidity(@RequestBody HumidityCreateDto humidityCreateDto) {
    var createdHumidity = humidityService.createHumidity(humidityCreateDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdHumidity);
  }

  @PutMapping("/update")
  public ResponseEntity<Humidity> updateHumidity(@RequestBody HumidityUpdateDto humidityUpdateDto) {
    var updatedHumidity = humidityService.updateHumidity(humidityUpdateDto);
    return ResponseEntity.ok(updatedHumidity);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteHumidity(@PathVariable Integer id) {
    humidityService.deleteHumidityById(id);
    return ResponseEntity.noContent().build();
  }
}
