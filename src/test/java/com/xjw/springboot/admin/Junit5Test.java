package com.xjw.springboot.admin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("测试类")
public class Junit5Test {

    @DisplayName("测试方法")
    @Test
    public void displayName(){
        System.out.println("1");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("执行前");
    }
}
