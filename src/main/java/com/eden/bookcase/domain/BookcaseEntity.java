package com.eden.bookcase.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bookcase")
public class BookcaseEntity extends BaseTimeEntity {
//  @CreatedBy | https://marsland.tistory.com/m/531

  @Id
  @Column(nullable = false, unique = true)
  private String id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false)
  private String ownerId;

  @Column(nullable = false)
  private boolean isPrivate;
}
