package com.eden.bookcase.book.api;

import com.eden.bookcase.book.dto.DaumBookResponseDto;
import com.eden.bookcase.book.service.BookService;
import com.eden.bookcase.book.vo.RequestSearchBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BookApi {
  BookService bookService;

  public BookApi(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/daum/book")
  public ResponseEntity<?> searchDaumBook(RequestSearchBook requestSearchBook) {
    DaumBookResponseDto daumBookResponseDto = bookService.searchBooksFromDaum(requestSearchBook);
    return ResponseEntity.ok(daumBookResponseDto);
  }
}
