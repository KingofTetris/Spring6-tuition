package com.atguigu.spring6.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired //虽然包里面都没有，但是可以从xml文件注入
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getBookStock(Integer bookId) {
        String sql = "select stock from t_book where book_id =?";
        Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
        return stock;
    }

    @Override
    public String getBookName(Integer bookId) {
        String sql = "select book_name from t_book where book_id =?";
        String book_name = jdbcTemplate.queryForObject(sql, String.class, bookId);
        return book_name;
    }

    @Override
    public Integer getBalance(Integer userId) {
        String sql = "select balance from t_user where user_id =?";
        Integer balance = jdbcTemplate.queryForObject(sql, Integer.class, userId);
        return balance;
    }

    @Override
    public Integer getBookPrice(Integer bookId) {
        String sql = "select price from t_book where book_id =?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
        return price;
    }

    @Override
    public void updateStock(Integer bookId) {
        Integer bookStock = getBookStock(bookId);
        if (bookStock <= 0 ){
            System.out.println("库存不足");
            return;
        }
        //改之前得保证stock不为0
        //更新库存
        String sql2 = "update t_book set stock= stock - 1 where book_id = ?";
        jdbcTemplate.update(sql2,bookId);
        String bookName = getBookName(bookId);
        System.out.println(bookName + "更新库存完毕,现有" + (bookStock - 1) + "本");
    }

    @Override
    public void updateUserBalance(Integer bookId,Integer userId) {
        Integer balance = getBalance(userId);
        Integer bookPrice = getBookPrice(bookId);
        if (balance < bookPrice){
            System.out.println("余额不足,快充值！！");
            return;
        }
        balance = balance - bookPrice;
        String sql = "update t_user set balance = ? where user_id = ?";
        jdbcTemplate.update(sql,balance,userId);
        System.out.println("购买成功，您的余额为" + balance);
    }

    @Override
    public void updateUserBalanceByBalance(Integer balance, Integer userId) {
        String sql = "update t_user set balance = ? where user_id = ?";
        jdbcTemplate.update(sql,balance,userId);
        System.out.println("购买成功，您的余额为" + balance);
    }

    @Override
    public void updateStockByBuyNumber(Integer bookId,Integer stockNow) {
        //改之前得保证stock不为0
        //更新库存
        String bookName = getBookName(bookId);
        String sql = "update t_book set stock = ? where book_id = ?";
        jdbcTemplate.update(sql,stockNow,bookId);
        System.out.println("<<" + bookName +">>" + "更新库存完毕,现有" + stockNow + "本");
    }

}
