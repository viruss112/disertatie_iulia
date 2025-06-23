package org.example.proiect_disertatie.domain.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class BaseResponse {

  private boolean isSuccessful;

}
