package com.eden.bookcase.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // 선언 필드 외에 모든 요소 제외
@Data
public class DaumBookResponseDto {
  private List<DaumBookDto> documents;
  private Meta meta;

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public static class DaumBookDto {
    private String title;
    private String url;
    private String thumbnail;
    private String[] authors;
    private String contents;
    private String datetime;
    private String isbn;
    private String publisher;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public static class Meta {
    @JsonProperty("is_end")
    private boolean isEnd;

    @JsonProperty("pageable_count")
    private int pageableCount;

    @JsonProperty("total_count")
    private int totalCount;
  }
}
