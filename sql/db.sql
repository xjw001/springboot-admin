CREATE TABLE `stock_info` (
  `stock_id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `stock_code` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `stock_history` (
  `history_id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '股票代码',
  `trade_date` date DEFAULT NULL COMMENT '交易日期',
  `start_price` decimal(10,3) DEFAULT NULL COMMENT '开盘价',
  `highest_price` decimal(10,3) DEFAULT NULL COMMENT '最高价',
  `end_price` decimal(10,3) DEFAULT NULL COMMENT '收盘价',
  `lowest_price` decimal(10,3) DEFAULT NULL COMMENT '最低价',
  `trade_amount` decimal(10,3) DEFAULT NULL COMMENT '成交量',
  `change_price` decimal(10,3) DEFAULT NULL COMMENT '涨跌额',
  `change_rate` decimal(10,3) DEFAULT NULL COMMENT '涨跌幅',
  `five_avg_price` decimal(10,3) DEFAULT NULL COMMENT '5日均价',
  `ten_avg_price` decimal(10,3) DEFAULT NULL COMMENT '10日均价',
  `twenty_avg_price` decimal(10,3) DEFAULT NULL COMMENT '20日均价',
  `five_avg_amount` decimal(10,3) DEFAULT NULL COMMENT '5日均量',
  `ten_avg_amount` decimal(10,3) DEFAULT NULL COMMENT '10日均量',
  `twenty_avg_amount` decimal(10,3) DEFAULT NULL COMMENT '20日均量',
  `trade_rate` decimal(10,3) DEFAULT NULL COMMENT '换手率',
  PRIMARY KEY (`history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin

