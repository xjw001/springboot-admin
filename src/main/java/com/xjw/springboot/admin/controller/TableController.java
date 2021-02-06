package com.xjw.springboot.admin.controller;

import com.xjw.springboot.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    private static final String PREFIX = "table";

    @GetMapping("/basic_table")
    public String basic_table(){
        return PREFIX+"/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
                new User("lisi", "4444"),
                new User("wangwu", "xxxxx"));
        model.addAttribute("users",users);
        return PREFIX+"/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return PREFIX+"/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return PREFIX+"/editable_table";
    }
}
