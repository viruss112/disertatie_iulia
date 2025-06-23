package org.example.proiect_disertatie.domain.dto.response;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserResponseDto extends BaseResponse{

  private Integer id;
  private String username;
  private String email;
  private String firstName;
  private String lastName;
  private Instant lastLogin;
  private String userRole;

}
