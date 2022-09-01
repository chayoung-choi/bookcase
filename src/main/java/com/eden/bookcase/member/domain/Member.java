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
  private String uid;
  private MemberStatus status;


  public Member(String uid, MemberStatus status) {
    this.uid = uid;
    this.status = status;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
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
