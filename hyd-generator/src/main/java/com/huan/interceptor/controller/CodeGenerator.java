package com.huan.interceptor.controller;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Author YueDong Huan
 * @Date 2021/5/19
 * @Email huanyued@163.com
 */
public class CodeGenerator {
    //01配置链接数据源
    public static DataSourceConfig dataSource() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        /**************这里请填写你的ip和你的端口号及数据库名称**************/
        //dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/yue?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        /*泉州*/
        dataSourceConfig.setUrl("jdbc:mysql://47.103.216.221:30017/gbf2quanzhou?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        /**************您的账号**************/
        /*泉州*/
        dataSourceConfig.setUsername("union_1");
        //dataSourceConfig.setUsername("root");
        /**************您的密码**************/
        /*泉州*/
        dataSourceConfig.setPassword("1qaz@WSX");
        //dataSourceConfig.setPassword("wojia");
        //您的数据库引擎
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        return dataSourceConfig;
    }

    //02配置全局
    public static GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        /**************路径**************/
        globalConfig.setOutputDir("D:\\java\\generator" + "/src/main/java");
        //不会默认打开文件夹
        globalConfig.setOpen(false);
        //创建者
        globalConfig.setAuthor("huan");
        //创建serviceImpl不会有大写的I
        globalConfig.setServiceName("%sService");
        return globalConfig;
    }

    //03配置包信息
    public static PackageConfig packageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        /**************父级包名**************/
        packageConfig.setParent("com.gobestsoft");
        //父级包名称
        packageConfig.setModuleName("icon");
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("entity");
        return packageConfig;
    }

    //04配置策略
    public static StrategyConfig strategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        //添加lombok
        strategyConfig.setEntityLombokModel(true);
        //下划线转驼峰
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //同上
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        /**************要生成的表名**************/
        strategyConfig.setInclude("cms_icon");
        return strategyConfig;
    }

    //04配置模板
    public static TemplateConfig templateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity("templates/entity.java");
        //templateConfig.setController();
        //templateConfig.setService();
        //templateConfig.setServiceImpl();
        //templateConfig.setMapper();
        //templateConfig.setXml();
        return templateConfig;
    }

    public static void main(String[] args) {
        //创建generator对象
        AutoGenerator autoGenerator = new AutoGenerator();
        //链接配置
        autoGenerator.setDataSource(dataSource());
        //全局配置
        autoGenerator.setGlobalConfig(globalConfig());
        //包信息
        autoGenerator.setPackageInfo(packageConfig());
        //配置策略
        autoGenerator.setStrategy(strategyConfig());
        //配置模板（还不熟练，配置失败）
        //autoGenerator.setTemplate(templateConfig());
        //去吧皮卡丘
        autoGenerator.execute();
    }
}
