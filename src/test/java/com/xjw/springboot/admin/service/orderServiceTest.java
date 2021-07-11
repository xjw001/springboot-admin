package com.xjw.springboot.admin.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xjw.springboot.admin.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class orderServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testRun() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                try {
                    cyclicBarrier.await();
                    bookService.sellBook();
                    System.out.println(Thread.currentThread().getName()+"::"+System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    @Test
    public void addBook(){
        Book book = new Book();
        book.setBookname("深入学习java虚拟机");
        book.setBoonum(3);
        boolean save = bookService.save(book);
        System.out.println(save);
    }

    @Test
    public void sellBook(){
        bookService.sellBook();
    }
}
