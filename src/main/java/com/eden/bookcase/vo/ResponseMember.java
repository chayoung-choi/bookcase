package com.eden.bookcase.vo;

import com.eden.bookcase.constants.UserStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMember {
  private String uid;
  private String name;
  private UserStatus status;
}
