package com.xjw.springboot.admin.controller;

import com.xjw.springboot.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session){
        if(!ObjectUtils.isEmpty(user.getUserName()) && StringUtils.hasLength(user.getPassword())){
            session.setAttribute("loginUser",user);
        }
        log.info("登录成功!");
        return "redirect:/main.html";
    }

    @GetMapping("/main.html")
    public String mainPage(){
        log.info("访问主页!");
        return "index";
    }
}
