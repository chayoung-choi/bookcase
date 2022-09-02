package com.eden.bookcase.book.controller;

import com.eden.bookcase.api.BookApi;
import com.eden.bookcase.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class BookApiTest {
  @MockBean
  BookService bookService;
  @Autowired
  private MockMvc mvc;

  @DisplayName("[API][GET] Daum 책 조회")
  @Test
  @Disabled
  void getDaumBook() throws Exception {
    RequestSearchBook requestSearchBook = new RequestSearchBook();
    requestSearchBook.setQuery("개발자");

    DaumBookResponseDto daumBookResponseDto = new DaumBookResponseDto();
    Mockito.when(bookService.searchBooksFromDaum(requestSearchBook)).thenReturn(daumBookResponseDto);

    mvc.perform(get("/daum/book?query=개발자"))
        .andExpect(status().isOk())
        .andDo(print());
  }

  @DisplayName("[API][GET] TEST")
  @Test
  void test() throws Exception {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("query", "개발자");

    mvc.perform(get("/test"))
        .andExpect(status().isOk())
        .andDo(print());
  }
}
