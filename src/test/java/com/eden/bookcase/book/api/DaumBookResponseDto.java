package com.eden.bookcase.book.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true) // 선언 필드 외에 모든 요소 제외
@Data
public class DaumBookResponseDto {
  private List<DaumBookDto> documents;
  private Meta meta;

  @JsonIgnoreProperties(ignoreUnknown=true)
  @Data
  static class DaumBookDto {
    private String title;
    private String url;
    private String thumbnail;
    private String[] authors;
    private String contents;
    private String datetime;
    private String isbn;
    private String publisher;
  }

  @JsonIgnoreProperties(ignoreUnknown=true)
  @Data
  static class Meta {
    private boolean is_end;
    private int pageable_count;
    private int total_count;
  }
}
