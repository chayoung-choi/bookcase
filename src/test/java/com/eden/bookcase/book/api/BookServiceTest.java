package com.eden.bookcase.book.api;

import com.eden.bookcase.book.dto.DaumBookResponseDto;
import com.eden.bookcase.book.service.BookService;
import com.eden.bookcase.book.vo.RequestSearchBook;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class BookServiceTest {

  @Autowired
  private BookService bookService;

  @DisplayName("Daum 책 조회")
  @Test
  void Daum_책_조회() {
    RequestSearchBook requestSearchBook = new RequestSearchBook();
    requestSearchBook.setQuery("개발자");

    DaumBookResponseDto daumBookResponseDto = bookService.searchBooksFromDaum(requestSearchBook);
    assertThat(daumBookResponseDto.getDocuments().size() > 0);
  }

  @DisplayName("Daum 책 검색결과 없음")
  @Test
  void Daum_책_검색결과_없음() {
    RequestSearchBook requestSearchBook = new RequestSearchBook();
    requestSearchBook.setQuery("ab개발자1");

    DaumBookResponseDto daumBookResponseDto = bookService.searchBooksFromDaum(requestSearchBook);
    assertThat(daumBookResponseDto.getMeta());
  }
}
