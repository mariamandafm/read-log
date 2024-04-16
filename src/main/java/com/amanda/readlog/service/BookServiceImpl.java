package com.amanda.readlog.service;

import com.amanda.readlog.model.Book;
import com.amanda.readlog.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

//    @Override
//    public List<Book> findAll() {
//        return new ArrayList<>(bookRepository.findAll());
//    }

    @Override
    public Optional<Book> findOne(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public boolean isExists(Long id) {
        return bookRepository.existsById(id);
    }

    @Override
    public Book partialUpdate(Long id, Book bookEntity) {
        // Mais "correto" definir o id de livro por aqui do que no controller
       bookEntity.setId(id);

       return bookRepository.findById(id).map(existingBook -> {
           Optional.ofNullable(bookEntity.getTitle()).ifPresent(existingBook::setTitle);
           Optional.ofNullable(bookEntity.getCover()).ifPresent(existingBook::setCover);
           Optional.ofNullable(bookEntity.getDescription()).ifPresent(existingBook::setDescription);
           Optional.ofNullable(bookEntity.getPublisher()).ifPresent(existingBook::setPublisher);
           Optional.ofNullable(bookEntity.getNumberOfPages()).ifPresent(existingBook::setNumberOfPages);
           Optional.ofNullable(bookEntity.getRating()).ifPresent(existingBook::setRating);
           return bookRepository.save(existingBook);
       }).orElseThrow(() -> new RuntimeException(("Book does not exists")));
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
