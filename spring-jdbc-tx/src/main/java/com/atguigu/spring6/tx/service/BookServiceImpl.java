package com.atguigu.spring6.tx.service;

import com.atguigu.spring6.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */

@Service

//Transactional里面有很多值，
// readOnly默认为false,设置为true，则这个类里面的方法只能查，不能改,你写了改会报错不被允许
//timeOut 事务超时就回滚,默认为-1，没有限制 单位是秒
//回滚策略，设置哪些异常不回滚
//隔离级别
//传播行为，事务之间的调用事务如何使用
//@Transactional(readOnly = true) //直接加到类上，就会影响所有类的方法
//@Transactional(timeout = 3) //直接加到类上，就会影响所有类的方法
//@Transactional(noRollbackFor = ArithmeticException.class) //表示ArithmeticException.class这类异常不回滚
//@Transactional(isolation = Isolation.DEFAULT) //表示隔离级别 DEFAULT 表示取数据库的默认隔离级别。
// Mysql默认是REPEATABLE READ 可重复读

//事务的传播行为，两个事务调用的时候怎么办？a方法有事务，b方法也有事务，如果a中调用了b
//那么事务该如何传递？合并到一起？还是开启一个新的事务？这就是事务的传播行为

@Transactional(propagation = Propagation.REQUIRED) //这个是默认的，如果不存在就建个新的。
//@Transactional(propagation = Propagation.REQUIRES_NEW) //这个是常用的，不管现在有没有都建个新的
//两个的区别用买书的例子说明一下就是
/**
 * 现在我两本书都想买，但是我的余额只能支持我买第一本书，买完以后第二本书就买不了了
 * 如果这个时候REQUIRED传播级别，那么整个事务都会回滚，不会出现任何错误
 *
 * 但如果是REQUIRES_NEW级别，则第一本书会买成功，余额也会扣掉，
 * 在买第二本书的时候会出错。
 * 这就是把每个子事务成功的都执行，不成功的不执行。
 */
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    //Service负责业务逻辑，Dao负责数据访问
    @Override
//    @Transactional //实际上业务逻辑层就是Service，基本上就只在这里加上事务标记
    public void buyBook(Integer bookId, Integer userId) {
        //1找到书的价格
        Integer price = bookDao.getBookPrice(bookId);
        //2.图书库存-1
        bookDao.updateStock(bookId);

        //问题是图书库存已经-1了，如果用户余额不足，要手动rollback，因此要开启tx
        //3.用户余额-图书价格
        bookDao.updateUserBalance(bookId,userId);
    }


    //买多本书 前面是ID,后面是数量
    @Override
    public void buyBooks(Map<Integer,Integer> books, Integer userId) {
        Integer totalPrice = 0;
        for (Map.Entry<Integer, Integer> entry : books.entrySet()) {
            //找到书的价格
            Integer bookPrice = bookDao.getBookPrice(entry.getKey());
            //乘以书的数量
            Integer count = entry.getValue();
            //书的数量要对应减少
            //获得当前库存
            Integer bookStock = bookDao.getBookStock(entry.getKey());
            //减去购买数量
            bookStock = bookStock - count;
            //更新库存
            bookDao.updateStockByBuyNumber(entry.getKey(),bookStock);
            //价格累加
            totalPrice = totalPrice + bookPrice * count;
        }
        //用户余额-totalPrice
        Integer balance = bookDao.getBalance(userId);
        balance = balance - totalPrice;
        //根据余额，更新用户余额。
        bookDao.updateUserBalanceByBalance(balance,userId);
    }
}
