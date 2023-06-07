package com.atguigu.spring6.tx.dao;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */
public interface BookDao {
    Integer getBookPrice(Integer bookId);

    void updateStock(Integer bookId);

    void updateUserBalance(Integer bookId,Integer userId);

    void updateUserBalanceByBalance(Integer balance,Integer userId);

    Integer getBookStock(Integer bookId);

    String getBookName(Integer bookId);

    Integer getBalance(Integer userId);

   void updateStockByBuyNumber(Integer bookId,Integer BuyNumber);
}
