package com.amanda.readlog.service;

import com.amanda.readlog.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book);

    Page<Book> findAll(Pageable pageable);

    Optional<Book> findOne(Long id);

    boolean isExists(Long id);

    Book partialUpdate(Long id, Book bookEntity);

    void delete(Long id);
}
