package com.eden.bookcase.book.service;

import com.eden.bookcase.book.dto.DaumBookResponseDto;
import com.eden.bookcase.book.vo.RequestSearchBook;
import com.eden.bookcase.utils.MultiValueMapConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
@Service
public class BookService {

  @Value("${app.kakao.host}")
  private String KAKAO_HOST;
  @Value("${app.kakao.api-key}")
  private String KAKAO_API_KEY;

  public DaumBookResponseDto searchBooksFromDaum(RequestSearchBook requestSearchBook) {
    ObjectMapper om = new ObjectMapper();
    MultiValueMap<String, String> params = MultiValueMapConverter.convert(om, requestSearchBook);

    WebClient client = WebClient.create(KAKAO_HOST);
    return client.get()
        .uri(builder -> builder.replacePath("/v3/search/book").queryParams(params).build())
        .header("Authorization", KAKAO_API_KEY)
        .retrieve()
        .bodyToMono(DaumBookResponseDto.class).block();
  }
}
