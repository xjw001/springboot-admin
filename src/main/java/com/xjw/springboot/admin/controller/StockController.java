package com.xjw.springboot.admin.controller;

import com.xjw.springboot.admin.service.StockHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {

    @Autowired
    private StockHistoryService stockHistoryService;

    @GetMapping("/stockinfo")
    public String stockInfo(){
        stockHistoryService.dobusiness("zhangsan");
        return "stock/stock_list";
    }
}
