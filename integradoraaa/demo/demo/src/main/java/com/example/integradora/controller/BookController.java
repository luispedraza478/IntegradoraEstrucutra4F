package com.example.integradora.controller;

import com.example.integradora.model.Book;
import com.example.integradora.service.LibraryService;
import com.example.integradora.structures.ArrayQueue;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final LibraryService libraryService;

    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @GetMapping
    public Object getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return libraryService.getBookById(id);
    }

    @PutMapping("/{id}/status")
    public String changeStatus(@PathVariable int id) {
        return libraryService.changeBookStatus(id);
    }

    @GetMapping("/{id}/waitlist")
    public Object getWaitlist(@PathVariable int id) {
        ArrayQueue<Integer> waitlist = libraryService.getWaitlistByBook(id);
        if (waitlist == null) {
            return "Libro no encontrado";
        }
        return waitlist;
    }
}
