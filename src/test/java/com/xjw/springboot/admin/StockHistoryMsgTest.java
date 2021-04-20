package com.xjw.springboot.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjw.springboot.admin.bean.StockHistory;
import com.xjw.springboot.admin.service.StockHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
    void showStockInfo(){
        for (int i = 1; i < 9; i++) {
            addSotckHistory(i);
        }
    }
    void addSotckHistory(int id){
        StockEnum stockEnum = StockEnum.getStockById(id);
        String url = "http://api.finance.ifeng.com/akdaily/?code="+stockEnum.getType()+stockEnum.getSotckCode()+"&type=last";
        Map<String, Object> paramMap = new HashMap();
        String values = restTemplate.getForObject(url, String.class,paramMap);

        JSONObject jsonObject1 = JSONObject.parseObject(values);
        JSONArray record = jsonObject1.getJSONArray("record");
        List<StockHistory> list = new ArrayList();
        int upcount = 0,lowcount = 0;
        BigDecimal upbd = new BigDecimal(0);
        BigDecimal lowbd = new BigDecimal(0);
        String startDate = null;
        String endDate = null;
        for (int i =0; i < record.size();i++) {
            JSONArray jsonArrayItem = (JSONArray)record.get(i);
            int year = Integer.parseInt(jsonArrayItem.getString(0).substring(0, 4));
            if(year <2021){
                continue;
            }
            if(startDate == null){
                startDate = jsonArrayItem.getString(0);
            }
            if(i == record.size()-1){
                endDate = jsonArrayItem.getString(0);
            }
//            System.out.print(stockEnum.getStockName()+",交易日期："+jsonArrayItem.get(0));
//            System.out.print(", 开盘价："+jsonArrayItem.get(1));
//            System.out.print(", 最高价："+jsonArrayItem.get(2));
//            System.out.print(", 收盘价："+jsonArrayItem.get(3));
//            System.out.print(", 最低价："+jsonArrayItem.get(4));
//           // System.out.print(", 成交量："+jsonArrayItem.get(5));
//            System.out.print(", 涨跌额："+jsonArrayItem.get(6));
//            System.out.print(", 涨跌幅："+jsonArrayItem.get(7)+"%");
////            System.out.print(", 5日均价："+jsonArrayItem.get(8));
////            System.out.print(", 10日均价："+jsonArrayItem.get(9));
////            System.out.print(", 20日均价："+jsonArrayItem.get(10));
////            System.out.print(", 5日均量："+jsonArrayItem.get(11));
////            System.out.print(", 10日均量："+jsonArrayItem.get(12));
////            System.out.print(", 20日均量："+jsonArrayItem.get(13));
//            System.out.print(", 换手率："+jsonArrayItem.get(14));
//            System.out.println();
            BigDecimal value = new BigDecimal(jsonArrayItem.getString(7));
            if(value.compareTo(BigDecimal.ZERO) > 0){
                upcount++;
                upbd = upbd.add(value);
            }else{
                lowcount++;
                lowbd = lowbd.add(value);
            }

        }

        System.out.print(StringUtils.rightPad(stockEnum.getStockName(),5," ")+"|");
        System.out.print("  开始日期:"+startDate);
        System.out.print("  结束日期:"+endDate);
        System.out.print("  上涨天数:"+upcount+" 累计上涨:"+upbd.toString()+"%");
        System.out.print("  下跌天数:"+lowcount+" 累计下跌:"+lowbd.toString()+"%");
        System.out.print("  整体涨幅:"+upbd.add(lowbd).toString()+"%");
        System.out.println();

       // stockHistoryService.saveBatch(list);
//        log.info("添加成功");
    }
}
