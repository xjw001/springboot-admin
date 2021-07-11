package com.xjw.springboot.admin.mapper;

import com.xjw.springboot.admin.bean.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xjw
 * @since 2021-07-10
 */
public interface BookMapper extends BaseMapper<Book> {

    void updateCount(@Param("purchaseCount") int purchaseCount,@Param("id") int id);
}
