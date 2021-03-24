package com.xjw.springboot.admin;

public enum  StockEnum {

    STOCK1(1,"sz","000011","深物业A"),
    STOCK2(2,"sz","002602","世纪华通");
    public final Integer id;
    public final String type;
    public final String sotckCode;
    public final String stockName;

    private StockEnum(Integer mid,String mtype,String msotckCode,String mstockName){
        id = mid;
        type = mtype;
        sotckCode = msotckCode;
        stockName = mstockName;
    }

    public String getSotckCode() {
        return sotckCode;
    }

    public String getStockName() {
        return stockName;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public static StockEnum getStockById(Integer id){
        for (StockEnum value : StockEnum.values()) {
            if(value.getId() == id){
                return value;
            }
        }
        return null;
    }
}
