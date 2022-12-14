package com.eden.bookcase.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class UserEntity extends BaseTimeEntity {

  @Id
  @Column(nullable = false, unique = true)
  private String id;

  @Column(nullable = false, length = 50)
  private String email;

  @Column(nullable = false, length = 50)
  private String name;
}
