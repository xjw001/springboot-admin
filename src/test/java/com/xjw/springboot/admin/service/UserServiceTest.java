package com.xjw.springboot.admin.service;

import com.xjw.springboot.admin.bean.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void addSysUserTest(){
        SysUser sysUser = new SysUser();
        sysUser.setUserName("张三");
        sysUser.setUserAccount("zhangsan");
        sysUser.setPassword("zhangsan");
        sysUserService.save(sysUser);
        log.info("保存成功");
    }
}
