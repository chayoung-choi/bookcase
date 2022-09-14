package com.eden.bookcase.exception;

import com.eden.bookcase.constants.ErrorCode;
import com.eden.bookcase.vo.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = {BusinessException.class})
  protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
    log.error("handleBusinessException : {}", e.getErrorCode());
    final ErrorCode errorCode = e.getErrorCode();
    final ErrorResponse response = new ErrorResponse(errorCode);
    return new ResponseEntity<>(response, errorCode.getHttpStatus());
  }

  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ErrorResponse> handleException(Exception e) {
    log.error("handleException : {}", e);
    final ErrorResponse response = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
