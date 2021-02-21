package com.xjw.springboot.admin.controller;

import com.xjw.springboot.admin.bean.Person;
import com.xjw.springboot.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(!ObjectUtils.isEmpty(user.getUserName()) && StringUtils.hasLength(user.getPassword())){
            session.setAttribute("loginUser",user);
            log.info("登录成功!");
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","账号或者密码错误");
            return "login";
        }
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("loginUser");
        return "login";
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        Object loginUser = session.getAttribute("loginUser");
        if(!ObjectUtils.isEmpty(loginUser)){
            log.info("访问主页!");
            return "index";
        }else{
            model.addAttribute("msg","请重新登录");
            return "login";
        }

    }


    @RequestMapping("/ext/msg")
    @ResponseBody
    public Person getAllUsers(){
        return new Person("zhangsan","123455");
    }
}
