package com.polarbookshop.catalogservice.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.polarbookshop.catalogservice.domain.BookNotFoundException;
import com.polarbookshop.catalogservice.domain.BookService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class) // 스프링 MVC 컴포넌트에 중점을 주고 명시적으로는 BookController 클래스를 타깃으로 하는 테스트 클래스임을 나타낸다.
public class BookControllerMvcTests {

    @Autowired
    private MockMvc mockMvc; // 모의 환경에서 웹 계층을 테스트하기 위한 유틸리티 클래스

    @MockitoBean // Mockito를 사용하여 BookService의 모의 객체를 생성한다.
    private BookService bookService;

    @Test
    void whenGetBookNotExistingThenShouldReturn404() throws Exception {
        String isbn = "73737313940";
        given(bookService.viewBookDetails(isbn)).willThrow(BookNotFoundException.class);

        mockMvc.perform(get("/books/" + isbn))
                .andExpect(status().isNotFound()); // HTTP 404 상태 코드가 반환되어야 함
    }
}
