package com.xjw.springboot.admin.controller;


import com.xjw.springboot.admin.bean.Msg;
import com.xjw.springboot.admin.bean.StockHistory;
import com.xjw.springboot.admin.service.StockHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xjw
 * @since 2021-02-21
 */
@Controller
@RequestMapping("/stockHistory")
public class StockHistoryController {

    public static final String REDIS_USER_TOKEN = "token";

    @Autowired
    private StockHistoryService stockHistoryService;

    @RequestMapping("/add")
    @ResponseBody
    public Msg addStockHistory(){
        StockHistory stockHistory = new StockHistory();
        stockHistory.setStockCode("000003");
        List list = new ArrayList();
        list.add(stockHistory);
        stockHistoryService.saveBatch(list);
        return Msg.success();
    }

}

