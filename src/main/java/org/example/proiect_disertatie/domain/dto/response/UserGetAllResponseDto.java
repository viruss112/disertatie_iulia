package org.example.proiect_disertatie.domain.dto.response;

import java.time.Instant;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserGetAllResponseDto extends  BaseResponse {

  private List<UserResponseDto> users;

}
