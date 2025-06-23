package org.example.proiect_disertatie.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.proiect_disertatie.domain.enums.Location;

@Data
@Setter
@Table(name = "humidity_sensor")
@Entity
@Accessors(chain = true)
public class Humidity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "UNIT_OF_MEASURE")
  private String unitOfMeasure;

  @Column(name = "VALUE")
  private Double value;

  @Column(name = "LOCATION")
  @Enumerated(EnumType.STRING)
  private Location location;

  @Column(name = "MEASURED_ON")
  private Instant measuredOn;
}
