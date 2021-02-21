package com.xjw.springboot.admin;

import com.xjw.springboot.admin.bean.StockHistory;
import com.xjw.springboot.admin.bean.StockInfo;
import com.xjw.springboot.admin.mapper.StockHistoryMapper;
import com.xjw.springboot.admin.mapper.StockInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@SpringBootTest
@Slf4j
class SpringbootAdminApplicationTests {

    @Autowired
    private StockInfoMapper stockInfoMapper;

    @Autowired
    private StockHistoryMapper stockHistoryMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testStockInfo(){
        List<StockInfo> stockInfoList = stockInfoMapper.selectList(null);
        stockInfoList.forEach(System.out::println);
    }

    @Test
    void testStockHistory(){
        StockHistory entity = new StockHistory();
        stockHistoryMapper.insert(entity);
    }
}
