package com.eden.bookcase.vo;

import lombok.Data;

@Data
public class RequestBook {
  private String title;
  private String url;
  private String thumbnail;
  private String[] authors;
  private String contents;
  private String datetime;
  private String isbn;
  private String publisher;

//  @NotNull(message = "Email cannot be null")
//  @Size(min = 2, message = "Email not be less then two characters")
//  private String email;
//
//  @NotNull(message = "Name cannot be null")
//  @Size(min = 2, message = "Name not be less then two characters")
//  private String name;
//
//  @NotNull(message = "Password cannot be null")
//  @Size(min = 8, message = "Password not be equal or grater then 8 characters")
//  private String pwd;
}
