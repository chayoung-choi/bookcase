package com.eden.bookcase.book.api;

import com.eden.bookcase.api.BookApi;
import com.eden.bookcase.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(BookApi.class)
public class BookApiTest {

  @MockBean
  BookService bookService;

  @Autowired
  private MockMvc mvc;

  @DisplayName("[API][GET] Daum 책 조회")
  @Test
  @Disabled
  void getDaumBook() throws Exception {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("query", "개발자");

    mvc.perform(get("/daum/book", params))
            .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(print());
  }
}
