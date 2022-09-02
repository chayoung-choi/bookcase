package com.eden.bookcase.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  @Column(nullable = false, unique = true)
  private String id;

  @Column(nullable = false, length = 50)
  private String email;

  @Column(nullable = false, length = 50)
  private String name;

//  @Column(nullable = false)
//  private String encryptedPwd;

//  private UserStatus status;

//
//  public User(String id, UserStatus status) {
//    this.id = id;
//    this.status = status;
//  }
//
//  public String getId() {
//    return id;
//  }
//
//  public void setId(String id) {
//    this.id = id;
//  }
//
//  public UserStatus getStatus() {
//    return status;
//  }
//
//  private void setStatus(UserStatus status) {
//    this.status = status;
//  }
//
//  public void confirm() {
//    if (getStatus() == UserStatus.ACTIVE) {
//      throw new MemberAlreadyActivatedException();
//    }
//    setStatus(UserStatus.ACTIVE);
//  }
}
