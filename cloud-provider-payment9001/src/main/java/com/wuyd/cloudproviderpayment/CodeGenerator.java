package com.wuyd.cloudproviderpayment;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * 代码生成类，需要时更改表名
 * 去除xml生成
 *
 * @author wuyd
 * 创建时间：2019/10/8 11:17
 */
public class CodeGenerator {


    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(System.getProperty("user.dir")+"/cloud-provider-payment9001/src/main/java");
        gc.setFileOverride(true);
        //不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(true);
        gc.setSwagger2(true);
        gc.setAuthor("wuYd");

        //自定义文件命名，注意%s 会自动填充表实体属性
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setEntityName("%sEntity");
        gc.setMapperName("%sMapper");

        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("6565333");
        dsc.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true&useUnicode=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=10&serverTimezone=Asia/Shanghai");
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        //此处可以修改您的表前缀
//        strategy.setTablePrefix("giftcenter_");
        //表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //需要生成的表
        strategy.setInclude(
        );

        strategy.setSuperMapperClass(null);
        strategy.setControllerMappingHyphenStyle(true);

        strategy.setEntityLombokModel(true);
        strategy.setEntitySerialVersionUID(true);
        strategy.setEntityTableFieldAnnotationEnable(true);

        mpg.setStrategy(strategy);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.wuyd.cloudproviderpayment");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        mpg.setPackageInfo(pc);

        //执行生成
        mpg.execute();
    }
}
