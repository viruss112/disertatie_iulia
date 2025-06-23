package org.example.proiect_disertatie.service;

import lombok.RequiredArgsConstructor;
import org.example.proiect_disertatie.domain.dto.request.HumidityCreateDto;
import org.example.proiect_disertatie.domain.dto.request.HumidityUpdateDto;
import org.example.proiect_disertatie.domain.entities.Humidity;
import org.example.proiect_disertatie.domain.enums.Location;
import org.example.proiect_disertatie.exception.HumidityGeneralException;
import org.example.proiect_disertatie.mapper.HumidityMapper;
import org.example.proiect_disertatie.repo.HumidityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HumidityService {

  private final HumidityRepository humidityRepository;


  public Humidity getLatestHumidity() {
    try {
      return humidityRepository.findTopByOrderByMeasuredOnDesc();
    } catch (Exception e) {
      throw new HumidityGeneralException("Error retrieving latest humidity data");
    }
  }

  @Transactional(rollbackFor = HumidityGeneralException.class)
  public Humidity createHumidity(HumidityCreateDto humidityCreateDto) {
    try {
      return humidityRepository.save(HumidityMapper.toEntity(humidityCreateDto));
    } catch (Exception e) {
      throw new HumidityGeneralException("Error saving humidity data");
    }
  }

  @Transactional(rollbackFor = HumidityGeneralException.class)
  public Humidity updateHumidity(HumidityUpdateDto humidityUpdateDto) {
    try {
      var humidity = humidityRepository.findById(humidityUpdateDto.getId()).orElseThrow(
          () -> new HumidityGeneralException(
              "Humidity sensor not found with ID: " + humidityUpdateDto.getId()));

      humidity.setUnitOfMeasure(humidityUpdateDto.getUnitOfMeasure())
          .setValue(humidityUpdateDto.getValue())
          .setLocation(Location.valueOf(humidityUpdateDto.getLocation()))
          .setMeasuredOn(humidityUpdateDto.getMeasuredOn());

      return humidityRepository.save(humidity);
    } catch (Exception e) {
      throw new HumidityGeneralException("Error updating humidity data: " + e.getMessage());
    }

  }

  @Transactional(rollbackFor = HumidityGeneralException.class)
  public void deleteHumidityById(Integer id) {
    if (!humidityRepository.existsById(id)) {
      throw new HumidityGeneralException("Humidity sensor not found with ID: " + id);
    }
    humidityRepository.deleteById(id);
  }
}
