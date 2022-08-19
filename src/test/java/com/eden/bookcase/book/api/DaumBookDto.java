package com.eden.bookcase.book.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown =true) // 선언 필드 외에 모든 요소 제외
@Data
public class DaumBookDto {
  private String title;
  private String url;
  private String thumbnail;
  private String[] authors;
  private String contents;
  private String datetime;
  private String isbn;
  private String publisher;
}
