package com.eden.bookcase.exception;

import com.eden.bookcase.constants.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {
  private final ErrorCode errorCode;
}
