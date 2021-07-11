package com.xjw.springboot.admin.service;

import com.xjw.springboot.admin.bean.Book;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xjw
 * @since 2021-07-10
 */
public interface BookService extends IService<Book> {

    void sellBook();
}
