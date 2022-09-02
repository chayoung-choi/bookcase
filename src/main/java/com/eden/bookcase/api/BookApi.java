package com.eden.bookcase.api;

import com.eden.bookcase.dto.DaumBookResponseDto;
import com.eden.bookcase.service.BookService;
import com.eden.bookcase.vo.RequestBook;
import com.eden.bookcase.vo.RequestSearchBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BookApi {
  private final BookService bookService;

  public BookApi(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/daum/books")
  @Description("Daum API를 이용하여 도서를 검색한다.")
  public ResponseEntity searchDaumBook(RequestSearchBook requestSearchBook) {
    DaumBookResponseDto daumBookResponseDto = bookService.searchBooksFromDaum(requestSearchBook);
    return ResponseEntity.ok(daumBookResponseDto);
  }

  @PostMapping("/books")
  @Description("도서를 등록한다.")
  public ResponseEntity registerBook(@RequestBody RequestBook requestBook) {
//    ModelMapper mapper = new ModelMapper();
//    DaumBookResponseDto daumBookResponseDto = bookService.searchBooksFromDaum(requestSearchBook);
    return ResponseEntity.status(HttpStatus.CREATED).body(requestBook);
  }
}
