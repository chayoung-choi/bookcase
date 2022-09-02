package com.eden.bookcase.domain;

import com.eden.bookcase.constants.UserStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String email;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = false, unique = true)
  private String uid;

  @Column(nullable = false)
  private String encryptedPwd;

  private UserStatus status;

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
