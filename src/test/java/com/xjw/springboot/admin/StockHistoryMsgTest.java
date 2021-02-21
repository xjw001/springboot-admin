package com.xjw.springboot.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjw.springboot.admin.bean.StockHistory;
import com.xjw.springboot.admin.service.StockHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
public class StockHistoryMsgTest {

    @Autowired
    private StockHistoryService stockHistoryService;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void addSotckHistory(){
        String url = "http://api.finance.ifeng.com/akdaily/?code=sz000011&type=last";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("code","sz002602");
        paramMap.put("type","last");
        String values = restTemplate.getForObject(url, String.class,paramMap);

        JSONObject jsonObject1 = JSONObject.parseObject(values);
        JSONArray record = jsonObject1.getJSONArray("record");
        List<StockHistory> list = new ArrayList();
        int upcount = 0,lowcount = 0;
        BigDecimal upbd = new BigDecimal(0);
        BigDecimal lowbd = new BigDecimal(0);
        for (Object o : record) {
            JSONArray jsonArrayItem = (JSONArray) o;
            int year = Integer.parseInt(jsonArrayItem.getString(0).substring(0, 4));
            if(year <2021){
                continue;
            }
            System.out.print("深物业,交易日期："+jsonArrayItem.get(0));
            System.out.print(", 开盘价："+jsonArrayItem.get(1));
            System.out.print(", 最高价："+jsonArrayItem.get(2));
            System.out.print(", 收盘价："+jsonArrayItem.get(3));
            System.out.print(", 最低价："+jsonArrayItem.get(4));
           // System.out.print(", 成交量："+jsonArrayItem.get(5));
            System.out.print(", 涨跌额："+jsonArrayItem.get(6));

            System.out.print(", 涨跌幅："+jsonArrayItem.get(7)+"%");
            BigDecimal value = new BigDecimal(jsonArrayItem.getString(7));
            if(value.compareTo(BigDecimal.ZERO) > 0){
                upcount++;
                upbd = upbd.add(value);
            }else{
                lowcount++;
                lowbd = lowbd.add(value);
            }
//            System.out.print(", 5日均价："+jsonArrayItem.get(8));
//            System.out.print(", 10日均价："+jsonArrayItem.get(9));
//            System.out.print(", 20日均价："+jsonArrayItem.get(10));
//            System.out.print(", 5日均量："+jsonArrayItem.get(11));
//            System.out.print(", 10日均量："+jsonArrayItem.get(12));
//            System.out.print(", 20日均量："+jsonArrayItem.get(13));
            System.out.print(", 换手率："+jsonArrayItem.get(14));
            System.out.println();
//            StockHistory entity = new StockHistory();
//            entity.setStockCode("002602"); //股票代码

//            //交易日期
//            entity.setTradeDate(LocalDate.parse(jsonArrayItem.getString(0), formatter));

        }

        System.out.println("开始日期:2020-01-01");
        System.out.println("结束日期:2020-12-31");
        System.out.println("上涨天数:"+upcount+",累计上涨:"+upbd.toString()+"%");
        System.out.println("下跌天数:"+lowcount+",累计下跌:"+lowbd.toString()+"%");


       // stockHistoryService.saveBatch(list);
//        log.info("添加成功");
    }
}
