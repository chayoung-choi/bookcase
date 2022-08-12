package com.eden.bookcase.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

  public ResponseEntity confirm(
          @PathVariable("id") String id
  ) {
    return ResponseEntity.ok("OK");
  }

}
