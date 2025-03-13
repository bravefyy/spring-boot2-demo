package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getbook")
    public void getBook() {
        Book book = bookService.selectById(2);

        System.out.println(book);

    }
}
