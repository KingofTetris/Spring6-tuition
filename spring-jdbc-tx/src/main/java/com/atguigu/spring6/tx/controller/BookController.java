package com.atguigu.spring6.tx.controller;

import com.atguigu.spring6.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */

@Controller
public class BookController {


    @Autowired
    private BookService bookService;

    //买书的方法
    public void buyBook(Integer bookId,Integer userId){
        bookService.buyBook(bookId,userId);
    }

    //买多本书
    public void buyBooks(Map<Integer,Integer> items,Integer userId){
        bookService.buyBooks(items,userId);
    }
}
