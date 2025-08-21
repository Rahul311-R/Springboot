package com.example.springboot;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class Bookcontroller {

    private List<Book> books = new ArrayList<>();

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book added!";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book) {
        for (Book b : books) {
            if (b.getId() == id) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                return "Book updated!";
            }
        }
        return "Book not found!";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        books.removeIf(b -> b.getId() == id);
        return "Book deleted!";
    }

}
