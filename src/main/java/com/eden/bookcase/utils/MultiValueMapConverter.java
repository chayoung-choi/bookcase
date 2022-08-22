package com.eden.bookcase.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE) // 유틸 클래스이니 상속이나 인스턴스 생성을 막기위해 private scope의 기본생성자
public class MultiValueMapConverter {
  public static MultiValueMap<String, String> convert(ObjectMapper objectMapper, Object dto) {
    try {
      MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
      Map<String, String> map = objectMapper.convertValue(dto, new TypeReference<Map<String, String>>() {
      });
      map.forEach((k, v) -> params.add(k, v.toLowerCase()));
      return params;
    } catch (Exception e) {
      log.error("Url Parameter 변환 중 오류 발생. requestDto={}", dto, e);
      throw new IllegalStateException("Url Parameter 변환 중 오류가 발생");
    }
  }
}
