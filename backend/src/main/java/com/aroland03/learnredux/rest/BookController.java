package com.aroland03.learnredux.rest;

import com.aroland03.learnredux.rest.dto.BookDTO;
import com.aroland03.learnredux.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public void create(@RequestBody @Valid BookDTO bookDTO) {
        bookService.create(bookDTO);
    }

    @GetMapping
    public Collection<BookDTO> getAll(@RequestParam(name = "name", required = false) String name) {
        return bookService.getAll(name);
    }

    @GetMapping("/{id}")
    public BookDTO getById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid BookDTO bookDTO) {
        bookService.update(id, bookDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @DeleteMapping
    public void deleteAll() {
        bookService.deleteAll();
    }
}
