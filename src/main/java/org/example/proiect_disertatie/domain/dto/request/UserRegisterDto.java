package org.example.proiect_disertatie.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {

  private String username;
  private String password;
  private String email;
  private String firstName;
  private String lastName;

}
