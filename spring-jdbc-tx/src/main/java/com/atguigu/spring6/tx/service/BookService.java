package com.atguigu.spring6.tx.service;

import java.util.List;
import java.util.Map;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */
public interface BookService {
    void buyBook(Integer bookId, Integer userId);

    void buyBooks(Map<Integer,Integer> bookIds, Integer userId);

}
