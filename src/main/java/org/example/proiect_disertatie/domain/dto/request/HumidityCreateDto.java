package org.example.proiect_disertatie.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HumidityCreateDto {

  private String unitOfMeasure;
  private Double value;
  private String location;
  private String measuredOn;

}
