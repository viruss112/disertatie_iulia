package org.example.proiect_disertatie.domain.dto.request;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HumidityUpdateDto {

  private Integer id;
  private String unitOfMeasure;
  private Double value;
  private String location;
  private Instant measuredOn;
}
