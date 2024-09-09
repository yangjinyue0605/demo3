package com.example.demo3.controller;

import com.example.demo3.dao.BookMapper;
import com.example.demo3.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangjinyue
 * @date 2024/09/06 11:40
 * Copyright
 */
@RestController
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @PostMapping("/insert")
    public Integer insertBook(@RequestBody Book book){
        bookMapper.insertBook(book);
        System.out.println();
        return book.getBookId();
    }

    @GetMapping("/getBook")
    public Book getBook(@RequestParam("bookId") Integer bookId){
        return bookMapper.getBook(bookId);
    }

    @PostMapping("/updateBook")
    public Integer updateBook(@RequestBody Book book){
        return bookMapper.updateBook(book);
    }

    @PutMapping("/deleteBook")
    public Integer deleteBook(@RequestParam("bookId") Integer bookId){
        return bookMapper.deleteBook(bookId);
    }


}
