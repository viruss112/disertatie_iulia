package org.example.proiect_disertatie.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserActivateOrDeactivateDto {

  private Integer id;
  private Boolean isActive;

}
