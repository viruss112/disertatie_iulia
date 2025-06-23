package org.example.proiect_disertatie.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Location {

  LIVING_ROOM("Living Room"),
  BEDROOM("Bedroom"),
  KITCHEN("Kitchen"),
  BATHROOM("Bathroom"),
  OFFICE("Office"),
  GARAGE("Garage"),
  OUTDOOR("Outdoor");

  private final String displayName;
}
