package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book(
        @NotBlank(message = "The book ISBN must be defined.") 
        @Pattern(regexp = "^([0-9]{10}|[0-9]{13})$", message = "The ISBN format must be valid.")  //  NotBlank 어노테이션은 빈 문자열이 아니어야 함을 나타내고, Pattern 어노테이션은 정규 표현식에 맞는 형식을 검증
        String isbn,

        @NotBlank(message = "The book title must be defined.")
        String title,

        @NotBlank(message = "The book author must be defined.")
        String author,

        @NotNull(message =  "The book price must be defined.")
        @Positive( // Positive 어노테이션은 값이 양수여야 함을 나타냄
            message = "The book price must be greater thatn zero."
        )
        double price) {
};
