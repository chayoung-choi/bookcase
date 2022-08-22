package com.eden.bookcase.book.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RequestSearchBook {
  private String query;
  private SortType sort; // 결과 문서 정렬 방식, accuracy(정확도순) 또는 latest(발간일순)
  private Integer page; // 결과 페이지 번호, 1~50 사이의 값, 기본 값 1
  private Integer size; // 한 페이지에 보여질 문서 수, 1~50 사이의 값
  private SearchTarget target; // 검색 필드 제한
}
