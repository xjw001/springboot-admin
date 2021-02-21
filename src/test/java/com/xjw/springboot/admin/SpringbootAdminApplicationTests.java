package com.xjw.springboot.admin;

import com.alibaba.druid.util.HttpClientUtils;
import com.xjw.springboot.admin.bean.StockHistory;
import com.xjw.springboot.admin.bean.StockInfo;
import com.xjw.springboot.admin.mapper.StockHistoryMapper;
import com.xjw.springboot.admin.mapper.StockInfoMapper;
import com.xjw.springboot.admin.service.StockHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Slf4j
class SpringbootAdminApplicationTests {

    @Autowired
    private StockInfoMapper stockInfoMapper;

    @Autowired
    private StockHistoryService stockHistoryService;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    TransactionDefinition transactionDefinition;

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
        entity.setStockCode("002602");
        entity.setTradeDate(LocalDate.now());
        stockHistoryService.save(entity);
    }

    @Test
    void testAddStockInfo(){
        StockInfo stockinfo = new StockInfo();
        stockinfo.setStockName("世纪华通");
        stockinfo.setStockCode("002602");
       // entity.setStockCode("002602");
        int insert = stockInfoMapper.insert(stockinfo);
        System.out.println(insert);
    }
}
