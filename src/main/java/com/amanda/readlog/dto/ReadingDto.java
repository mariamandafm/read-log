package com.amanda.readlog.dto;

import com.amanda.readlog.model.Book;
import com.amanda.readlog.model.Club;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadingDto {
    private Integer id;
    private BookDto book;
    private Date startDate;
    private Date endDate;
    private boolean finished = false;
}
