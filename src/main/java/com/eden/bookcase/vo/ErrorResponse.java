package com.eden.bookcase.vo;

import com.eden.bookcase.constants.ErrorCode;
import lombok.Data;

@Data
public class ErrorResponse {
  private int status;
  private String error;
  private String message;

  public ErrorResponse(ErrorCode errorCode) {
    this.status = errorCode.getHttpStatus().value();
    this.error = errorCode.name();
    this.message = errorCode.getMessage();
  }
}
