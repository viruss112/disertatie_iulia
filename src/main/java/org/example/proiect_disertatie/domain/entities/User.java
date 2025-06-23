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
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.proiect_disertatie.domain.enums.UserRole;

@Entity
@Getter
@Setter
@Table(name = "app_user")
@Accessors(chain = true)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "USERNAME")
  private String username;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "IS_ACTIVE")
  private Boolean isActive;

  @Column(name = "LAST_LOGIN")
  private Instant lastLogin;

  @Column(name = "USER_ROLE")
  @Enumerated(EnumType.STRING)
  private UserRole userRole;
}
