package com.atguigu.spring6.iocxml.di;

/**
 * @author by KingOfTetris
 * @date 2023/5/24
 */
public class Book {

    private String bname;
    private String author;

    //others是为了说明特殊值处理
    private String others;

    public String getBname() {
        return bname;
    }

    public String getAuthor() {
        return author;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public Book() {

    }
    public Book(String bname, String author) {
        this.bname = bname;
        this.author = author;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }
}
