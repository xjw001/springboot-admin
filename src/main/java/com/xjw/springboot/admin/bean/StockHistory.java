package com.xjw.springboot.admin.bean;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xjw
 * @since 2021-02-21
 */
public class StockHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "history_id", type = IdType.AUTO)
    private Integer historyId;

    /**
     * 股票代码
     */
    private String stockCode;

    /**
     * 交易日期
     */
    private LocalDate tradeDate;

    /**
     * 开盘价
     */
    private BigDecimal startPrice;

    /**
     * 最高价
     */
    private BigDecimal highestPrice;

    /**
     * 收盘价
     */
    private BigDecimal endPrice;

    /**
     * 最低价
     */
    private BigDecimal lowestPrice;

    /**
     * 成交量
     */
    private BigDecimal tradeAmount;

    /**
     * 涨跌额
     */
    private BigDecimal changePrice;

    /**
     * 涨跌幅
     */
    private BigDecimal changeRate;

    /**
     * 5日均价
     */
    private BigDecimal fiveAvgPrice;

    /**
     * 10日均价
     */
    private BigDecimal tenAvgPrice;

    /**
     * 20日均价
     */
    private BigDecimal twentyAvgPrice;

    /**
     * 5日均量
     */
    private BigDecimal fiveAvgAmount;

    /**
     * 10日均量
     */
    private BigDecimal tenAvgAmount;

    /**
     * 20日均量
     */
    private BigDecimal twentyAvgAmount;

    /**
     * 换手率
     */
    private BigDecimal tradeRate;


    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public BigDecimal getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(BigDecimal highestPrice) {
        this.highestPrice = highestPrice;
    }

    public BigDecimal getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(BigDecimal endPrice) {
        this.endPrice = endPrice;
    }

    public BigDecimal getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(BigDecimal lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public BigDecimal getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(BigDecimal changePrice) {
        this.changePrice = changePrice;
    }

    public BigDecimal getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(BigDecimal changeRate) {
        this.changeRate = changeRate;
    }

    public BigDecimal getFiveAvgPrice() {
        return fiveAvgPrice;
    }

    public void setFiveAvgPrice(BigDecimal fiveAvgPrice) {
        this.fiveAvgPrice = fiveAvgPrice;
    }

    public BigDecimal getTenAvgPrice() {
        return tenAvgPrice;
    }

    public void setTenAvgPrice(BigDecimal tenAvgPrice) {
        this.tenAvgPrice = tenAvgPrice;
    }

    public BigDecimal getTwentyAvgPrice() {
        return twentyAvgPrice;
    }

    public void setTwentyAvgPrice(BigDecimal twentyAvgPrice) {
        this.twentyAvgPrice = twentyAvgPrice;
    }

    public BigDecimal getFiveAvgAmount() {
        return fiveAvgAmount;
    }

    public void setFiveAvgAmount(BigDecimal fiveAvgAmount) {
        this.fiveAvgAmount = fiveAvgAmount;
    }

    public BigDecimal getTenAvgAmount() {
        return tenAvgAmount;
    }

    public void setTenAvgAmount(BigDecimal tenAvgAmount) {
        this.tenAvgAmount = tenAvgAmount;
    }

    public BigDecimal getTwentyAvgAmount() {
        return twentyAvgAmount;
    }

    public void setTwentyAvgAmount(BigDecimal twentyAvgAmount) {
        this.twentyAvgAmount = twentyAvgAmount;
    }

    public BigDecimal getTradeRate() {
        return tradeRate;
    }

    public void setTradeRate(BigDecimal tradeRate) {
        this.tradeRate = tradeRate;
    }

    @Override
    public String toString() {
        return "StockHistory{" +
        "historyId=" + historyId +
        ", stockCode=" + stockCode +
        ", tradeDate=" + tradeDate +
        ", startPrice=" + startPrice +
        ", highestPrice=" + highestPrice +
        ", endPrice=" + endPrice +
        ", lowestPrice=" + lowestPrice +
        ", tradeAmount=" + tradeAmount +
        ", changePrice=" + changePrice +
        ", changeRate=" + changeRate +
        ", fiveAvgPrice=" + fiveAvgPrice +
        ", tenAvgPrice=" + tenAvgPrice +
        ", twentyAvgPrice=" + twentyAvgPrice +
        ", fiveAvgAmount=" + fiveAvgAmount +
        ", tenAvgAmount=" + tenAvgAmount +
        ", twentyAvgAmount=" + twentyAvgAmount +
        ", tradeRate=" + tradeRate +
        "}";
    }
}
