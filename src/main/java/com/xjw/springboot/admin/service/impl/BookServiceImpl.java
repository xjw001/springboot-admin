package com.xjw.springboot.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xjw.springboot.admin.bean.Book;
import com.xjw.springboot.admin.mapper.BookMapper;
import com.xjw.springboot.admin.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xjw
 * @since 2021-07-10
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void sellBook() {
        QueryWrapper<Book> queryWrapper=new QueryWrapper();
        // QueryWrapper<Employee> queryWrapper2=Wrappers.<Employee>query();
        queryWrapper.eq("bookname","深入学习java虚拟机");
        Book book = bookMapper.selectOne(queryWrapper);
        int bookCount = book.getBoonum();
        if(bookCount <= 0){
            System.out.println("["+book.getBookname()+"]已销完");
            throw new RuntimeException("["+book.getBookname()+"]已销完");
        }
        System.out.println("售前:"+bookCount);
        book.setBoonum(bookCount-1);
        //bookMapper.updateById(book);
        bookMapper.updateCount(1,book.getId());
        System.out.println("售后："+(bookCount-1));
    }
}
