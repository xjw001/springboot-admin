package com.xjw.springboot.admin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MPtest {

    ///jdbc:mysql://localhost:3306/amserver?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai
    public static final String URL = "jdbc:mysql://192.168.0.187:3306/z_jg?useUnicode=true&characterEncoding=utf8";
    //com.mysql.cj.jdbc.Driver
    public static final String driverName = "com.mysql.jdbc.Driver";

    public static final String USERNAME = "root";
    public static final String PASSWORD = "huirong";

    public static void main(String[] args) {
        //1全局配置
        GlobalConfig config = new GlobalConfig();
        config.setOutputDir(System.getProperty("user.dir")+ "/src/main/java")
                .setAuthor("xjw")
                .setFileOverride(true)
                .setIdType(IdType.AUTO)
                .setServiceName("%sService")//生成的service不带I
                .setBaseResultMap(true)
                .setBaseColumnList(true);
        //2数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(URL);
        dataSourceConfig.setDriverName(driverName);
        dataSourceConfig.setUsername(USERNAME);
        dataSourceConfig.setPassword(PASSWORD);
        //3策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setInclude("sys_user")
        .setNaming(NamingStrategy.underline_to_camel);

        //4包策略配置
        PackageConfig packageConfig = new PackageConfig();
            packageConfig.setParent("com.xjw.springboot.admin")
                    .setMapper("mapper")
                    .setService("service")
                    .setController("controller")
                    .setEntity("bean")
                    .setXml("mapper");
        //5整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setStrategy(stConfig);
        autoGenerator.execute();
    }
}
