package com.eden.bookcase.member.vo;

import com.eden.bookcase.member.domain.MemberStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMember {
  private String uid;
  private String name;
  private MemberStatus status;
}
