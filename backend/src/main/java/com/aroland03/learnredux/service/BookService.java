package com.aroland03.learnredux.service;

import com.aroland03.learnredux.model.BookState;
import com.aroland03.learnredux.rest.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BookService {

    private Long idSource = 0L;
    private Map<Long, BookDTO> books;

    public BookService() {
        this.books = new HashMap<>();
        addBook(BookDTO.builder()
                .title("Borzalmak városa")
                .author("Stephen King")
                .state(BookState.UNREAD)
                .year(1975)
                .coverUrl("http://books.google.com/books/content?id=sr7LDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api")
                .build());
        addBook(BookDTO.builder()
                .title("Tortúra")
                .author("Stephen King")
                .state(BookState.READING)
                .year(1987)
                .coverUrl("https://books.google.com/books/content?id=iyTdDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api")
                .build());
    }

    public void create(BookDTO book) {
        addBook(book);
    }

    public Collection<BookDTO> getAll(String name) {
        if (name == null) {
            return books.values();
        }
        return this.books.values().stream()
                .filter(book -> book.getTitle().contains(name))
                .toList();
    }

    public BookDTO getById(Long id) {
        return checkBook(id);
    }

    public void update(Long id, BookDTO bookDTO) {
        BookDTO book = checkBook(id);

        if(bookDTO.getTitle() != null) {
            book.setTitle(bookDTO.getTitle());
        }
        if(bookDTO.getAuthor() != null) {
            book.setAuthor(bookDTO.getAuthor());
        }
        if(bookDTO.getState() != null) {
            book.setState(bookDTO.getState());
        }
        if(bookDTO.getYear() != 0) {
            book.setYear(bookDTO.getYear());
        }
        if(bookDTO.getCoverUrl() != null) {
            book.setCoverUrl(bookDTO.getCoverUrl());
        }
    }

    public void delete(Long id) {
        checkBook(id);
        this.books.remove(id);
    }

    public void deleteAll() {
        this.books.clear();
    }


    private BookDTO checkBook(Long id) {
        Optional<BookDTO> book = Optional.ofNullable(this.books.get(id));
        if(book.isEmpty()) {
            throw new RuntimeException("Book not found");
        }
        return book.get();
    }
    private void addBook(BookDTO book) {
        Long id = idSource++;
        BookDTO bookDTO = BookDTO.builder()
                .id(id)
                .title(book.getTitle())
                .author(book.getAuthor())
                .state(book.getState())
                .year(book.getYear())
                .coverUrl(book.getCoverUrl())
                .build();
        this.books.put(id, bookDTO);
    }
}
