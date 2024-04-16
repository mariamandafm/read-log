package com.amanda.readlog.repository;

import com.amanda.readlog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends CrudRepository<Book, Long>, PagingAndSortingRepository<Book, Long> {
}
