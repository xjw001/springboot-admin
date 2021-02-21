package com.xjw.springboot.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {


    @GetMapping("/stockinfo")
    public String stockInfo(){
        return "stock_list";
    }
}
