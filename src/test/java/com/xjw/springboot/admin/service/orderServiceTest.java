package com.xjw.springboot.admin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class orderServiceTest {

    @Test
    public void testRun() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                try {
                    cyclicBarrier.await();
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
}
