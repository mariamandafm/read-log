package com.amanda.readlog.controller;

import com.amanda.readlog.dto.BookDto;
import com.amanda.readlog.mappers.Mapper;
import com.amanda.readlog.model.Book;
import com.amanda.readlog.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
class BookController {

    private BookService bookService;

    private Mapper<Book, BookDto> bookMapper;

    public BookController(BookService bookService, Mapper<Book, BookDto> bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping(path = "/books")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto book) {
        Book bookEntity = bookMapper.mapFrom(book);
        Book savedBookEntity = bookService.save(bookEntity);
        BookDto savedBookDto = bookMapper.mapTo(savedBookEntity);

        return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED);
    }

    @GetMapping(path= "/books")
    public Page<BookDto> listBooks(Pageable pageable){
        Page<Book> books = bookService.findAll(pageable);
        return books.map(bookMapper::mapTo);
    }

    @GetMapping(path= "/books/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable("id") Long id){
        Optional<Book> foundBook = bookService.findOne(id);
        return foundBook.map(book -> {
            BookDto bookDto = bookMapper.mapTo(book);
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(path= "/books/{id}")
    public ResponseEntity<BookDto> fullUpdateBook (@PathVariable("id") Long id, @RequestBody BookDto bookDto){
        if(!bookService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookDto.setId(id);
        Book bookEntity = bookMapper.mapFrom(bookDto);
        Book savedBookEntity = bookService.save(bookEntity);
        return new ResponseEntity<>(bookMapper.mapTo(savedBookEntity), HttpStatus.OK);
    }

    @PatchMapping(path="/books/{id}")
    public ResponseEntity<BookDto> partialUpdate (@PathVariable("id") Long id, @RequestBody BookDto bookDto){
        if(!bookService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Book bookEntity = bookMapper.mapFrom(bookDto);
        Book updatedBook = bookService.partialUpdate(id, bookEntity);
        return new ResponseEntity<>(bookMapper.mapTo(updatedBook), HttpStatus.OK);
    }

    @DeleteMapping(path="/books/{id}")
    public ResponseEntity deleteBook(@PathVariable("id") Long id){
        bookService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
