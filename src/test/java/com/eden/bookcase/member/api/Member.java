package com.eden.bookcase.member.api;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="members")
public class Member {

  private String id;

  private MemberStatus status;

  public Member(String id, MemberStatus status) {
    this.id = id;
    this.status = status;
  }

  public Member() {

  }
}
