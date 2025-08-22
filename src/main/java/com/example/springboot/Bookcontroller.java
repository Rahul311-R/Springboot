package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class Bookcontroller {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getall(){
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getbook(@PathVariable int id){
        return bookService.getBook(id);
    }

    @PostMapping
    public String addbook(@RequestBody Book book){
        bookService.addBook(book);
        return "Book Added";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id,@RequestBody Book book){
        bookService.updatebook(id , book);
        return "Updated Book";
    }

    @DeleteMapping("/{id}")
    public String del(@PathVariable int id){
        bookService.delete(id);
        return "deleted";
    }



}
