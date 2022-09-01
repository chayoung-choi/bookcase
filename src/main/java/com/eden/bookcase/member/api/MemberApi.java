package com.eden.bookcase.member.api;

import com.eden.bookcase.member.service.ConfirmMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApi {

  private final ConfirmMemberService confirmMemberService;

  public MemberApi(ConfirmMemberService confirmMemberService) {
    this.confirmMemberService = confirmMemberService;
  }

  @GetMapping("/members/${uid}")
  public ResponseEntity getMember(@PathVariable String uid) {
//    ResponseMember returnValue = new ModelMapper().map(userDto, ResponseMember.class);
//    return ResponseEntity.ok(ResponseMember);
    return ResponseEntity.ok("OK");
  }

  @PostMapping("/members/{uid}/confirm")
  public ResponseEntity<?> confirm(@PathVariable String uid) {

    confirmMemberService.confirm(uid);
    return ResponseEntity.ok("OK");
  }
}
