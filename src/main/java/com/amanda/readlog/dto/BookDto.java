package com.amanda.readlog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private Integer numberOfPages;
    private String description;
    private Integer rating;
    private String cover;
}
