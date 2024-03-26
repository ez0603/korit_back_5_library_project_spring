package com.study.library.dto;

import com.study.library.entity.Book;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RegisterBookReqDto {
    private String isbn;
    @Min(value = 1, message = "숫자만 입력 가능합니다.") // Min = int(정수)만 가능, 최솟값 = 1
    private int bookTypeId;
    @Min(value = 1, message = "숫자만 입력 가능합니다.")
    private int categoryId;
    @NotBlank(message = "도서명은 빈 값일 수 없습니다.") // NotBlank = 공백, null, 띄어쓰기 X
//    @NotNull // null 체크
//    @Null // null 체크 (값이 무조건 null이어야함)
//    @Empty // 공백만 체크 (null 체크 X)
    private String bookName;
    @NotBlank(message = "저자명은 빈 값일 수 없습니다.")
    private String authorName;
    @NotBlank(message = "출판사는 빈 값일 수 없습니다.")
    private String publisherName;
    @NotBlank(message = "커버 이미지는 빈 값일 수 없습니다.")
    private String coverImgUrl;

    public Book toEntity() {
        return Book.builder()
                .bookName(bookName)
                .authorName(authorName)
                .publisherName(publisherName)
                .isbn(isbn)
                .bookTypeId(bookTypeId)
                .categoryId(categoryId)
                .coverImgUrl(coverImgUrl)
                .build();
    }
}
