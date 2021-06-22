package com.xjw.springboot.admin.service.impl;

import com.xjw.springboot.admin.bean.StockHistory;
import com.xjw.springboot.admin.mapper.StockHistoryMapper;
import com.xjw.springboot.admin.service.StockHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xjw
 * @since 2021-02-21
 */
@Service
@Slf4j
public class StockHistoryServiceImpl extends ServiceImpl<StockHistoryMapper, StockHistory> implements StockHistoryService {

    @Autowired
    StockHistoryMapper stockHistoryMapper;

    @Override
    @Transactional
    public boolean saveBatch(Collection<StockHistory> entityList) {
        for (StockHistory stockHistory : entityList) {
            stockHistoryMapper.insert(stockHistory);
        }
        return true;
    }

    @Override
    public void dobusiness(String name) {
        int v = 10/0;
        log.info("业务方法");
    }
}
