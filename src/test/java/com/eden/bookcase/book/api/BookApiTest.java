package com.eden.bookcase.book.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.parser.Authorization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookApiTest {

//  private final Environment env;
//
//  public BookApiTest(Environment env) {
//    this.env = env;
//  }

  @Test
  void 책_조회() {

    String title = "책장";
    String result = searchBooksFromDaum(title);

    assertThat(result == null);
  }


  private String searchBooksFromDaum(String title) {
    WebClient client = WebClient.create("https://dapi.kakao.com");
//    MultiValueMap<String, String> params = Map.of("query","개발자","target","title");
    String result = client.get()
      .uri("/v3/search/book?target=title&query=개발자")
        .header("Authorization", "{api-key}")
      .retrieve()
      .bodyToMono(String.class).block();
    System.out.println(result);
    return "";
  }
}
