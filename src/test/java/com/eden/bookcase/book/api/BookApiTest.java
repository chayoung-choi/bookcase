package com.eden.bookcase.book.api;

import com.eden.bookcase.book.dto.DaumBookResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@Slf4j
@RestClientTest(BookApi.class)
public class BookApiTest {
  @Autowired
  private MockRestServiceServer mockServer;

  @Test
  void Daum_책_조회_API() {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("query", "개발자");

    DaumBookResponseDto daumBookResponseDto = new DaumBookResponseDto();

    mockServer
        .expect(requestTo("/daum/book"))
        .andExpect(method(HttpMethod.GET))
        .andRespond(withSuccess(daumBookResponseDto.toString(), MediaType.APPLICATION_JSON));

    log.info(daumBookResponseDto.toString());
  }
}
