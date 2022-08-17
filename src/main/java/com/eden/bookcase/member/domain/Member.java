package com.eden.bookcase.member.domain;

import com.eden.bookcase.member.exception.MemberAlreadyActivatedException;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@NoArgsConstructor
public class Member {

  @Id
  private String id;
  private MemberStatus status;


  public Member(String id, MemberStatus status) {
    this.id = id;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public MemberStatus getStatus() {
    return status;
  }

  private void setStatus(MemberStatus status) {
    this.status = status;
  }

  public void confirm() {
    if (getStatus() == MemberStatus.ACTIVE) {
      throw new MemberAlreadyActivatedException();
    }
    setStatus(MemberStatus.ACTIVE);
  }
}
