package com.xjw.springboot.admin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xjw
 * @since 2021-07-10
 */
public class Book implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String bookname;

    private Integer boonum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getBoonum() {
        return boonum;
    }

    public void setBoonum(Integer boonum) {
        this.boonum = boonum;
    }

    @Override
    public String toString() {
        return "Book{" +
        "id=" + id +
        ", bookname=" + bookname +
        ", boonum=" + boonum +
        "}";
    }
}
