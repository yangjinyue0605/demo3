package com.example.demo3.dao;

import com.example.demo3.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangjinyue
 * @date 2024/09/07 14:56
 * Copyright
 */
@Mapper
public interface BookMapper {

    /**
     * 新增书籍
      * @param book 书
     * @return java.lang.Integer
     * @author yangjinyue
     * @date 2024/09/07 15:39
     */
    int insertBook(Book book);

    /**
     * 查询数据
      * @param bookId 书籍id
     * @return com.example.demo3.entity.Book
     * @author yangjinyue
     * @date 2024/09/07 21:13
     */
    Book getBook(Integer bookId);

    /**
     * 修改数据
      * @param book 书
     * @return java.lang.Integer
     * @author yangjinyue
     * @date 2024/09/07 21:17
     */
    Integer updateBook(Book book);

    /**
     * 删除数据
      * @param bookId 书id
     * @return java.lang.Integer
     * @author yangjinyue
     * @date 2024/09/07 21:19
     */
    Integer deleteBook(Integer bookId);
}
