package com.eden.bookcase.book.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class BookApiTest {

  @Value("${app.kakao.host}")
  private String KAKAO_HOST;
  @Value("${app.kakao.api-key}")
  private String KAKAO_API_KEY;

  @Test
  void Daum_책_조회() {
    String title = "개발자";

    DaumBookResponseDto daumBookResponseDto = searchBooksFromDaum(title);
    daumBookResponseDto.getDocuments().forEach(b -> log.info(b.getTitle()));
    log.info("[daumBookResponseDto] {}", daumBookResponseDto);

    assertThat(Objects.nonNull(daumBookResponseDto.getDocuments()));
  }

  private DaumBookResponseDto searchBooksFromDaum(String title) {
    WebClient client = WebClient.create(KAKAO_HOST);
    return client.get()
        .uri(String.format("/v3/search/book?target=title&query=%s", title))
        .header("Authorization", KAKAO_API_KEY)
        .retrieve()
        .bodyToMono(DaumBookResponseDto.class).block();
  }
}
