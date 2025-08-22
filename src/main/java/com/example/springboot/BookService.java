package com.example.springboot;

import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class BookService {

    private List<Book> books = new ArrayList<>();

    public List<Book> getAll(){
        return books;
    }

    public Book getBook(int id){
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void updatebook(int id,Book book){
        Book search = getBook(id);
        search.setTitle(book.getTitle());
        search.setAuthor(book.getAuthor());
    }

    public void delete(int id){
        Book num = getBook(id);
        books.remove(num);
    }

}
