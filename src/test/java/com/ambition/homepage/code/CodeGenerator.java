package com.ambition.homepage.code;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @author Ambition
 * @date 2023/10/31 15:50
 */
@SpringBootTest
public class CodeGenerator {
    /**
     * 代码生成器
     * mybaits-plus 版本为 3.4.0
     */
    @Test
    public void run() {
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();

        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");

        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("Ambition");
        gc.setOpen(false);
        gc.setFileOverride(false); // 是否覆盖
        gc.setServiceName("%sService"); // 去Service的I前缀
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
//2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/homepage?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("w1VJ6kR4");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
//3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("homepage"); // 模块名
        pc.setParent("com.ambition");
        pc.setEntity("model.entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);
//4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("education", "skills", "projects", "work"); // 设置要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); // 自动lombok；
        strategy.setLogicDeleteFieldName("is_deleted");
// 自动填充配置
        TableFill gmtCreate = new TableFill("created_at", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("updated_at",
                FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
// 乐观锁
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true); //

        mpg.setStrategy(strategy);
        mpg.execute(); //执行
    }

    /**
     * 代码生成器
     * mybaits-plus 版本为 3.5.4 较高的版本
     */
//    @Test
//    void testGenerator() {
//
//        String projectPath = System.getProperty("user.dir");
//        System.out.println(projectPath);
//        // 数据源配置
//        DataSourceConfig.Builder dataSourceConfig = new DataSourceConfig
//                .Builder(
//                "jdbc:mysql://127.0.0.1:3306/homepage?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8",
//                "root",
//                "w1VJ6kR4")
//                .dbQuery(new MySqlQuery())
//                .typeConvert(new MySqlTypeConvert())
//                .keyWordsHandler(new MySqlKeyWordsHandler());
//
//        FastAutoGenerator.create(dataSourceConfig)
//                .globalConfig(builder -> {
//                    builder.author("Ambition") //设置作者
//                            .commentDate("YYYY-MM-DD HH:mm:ss")//注释日期
//                            .outputDir(projectPath + "/java"); //指定输出目录
//
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.ambition") // 设置父包名
//                            .moduleName("homepage") // 设置父包模块名
//                            .entity("model")
//                            .service("service") // service包名
//                            .serviceImpl("service.impl") // serviceImpl包名
//                            .mapper("mapper") // mapper包名
//                            .controller("controller") // Controller 包名	默认值:controller
//                            .other("param") // 自定义文件包名	输出自定义文件时所用到的包名
//                            .pathInfo(Collections.singletonMap(OutputFile.entity, projectPath + "/src/main/java"))
//                            .pathInfo(Collections.singletonMap(OutputFile.mapper, projectPath + "/src/main/resources/mapper")); // 设置mapperXml生成路径
//                })
//                .strategyConfig(builder -> {
////
//                    builder.addInclude("education","skills","projects","work") // 设置需要生成的表名 请输入表名，多个英文逗号分隔？所有输入 all:
//                            .addTablePrefix("t_")// 设置过滤表前缀
//
//                            // Entity 策略配置
//                            .entityBuilder()
//                            .enableLombok() // 开启lombok
//                            .enableChainModel() // 链式
//                            .enableRemoveIsPrefix() // 开启boolean类型字段移除is前缀
//                            .enableTableFieldAnnotation() //开启生成实体时生成的字段注解
////                            .versionColumnName("") // 乐观锁数据库字段
////                            .versionPropertyName("") // 乐观锁实体类名称
//                            .logicDeleteColumnName("is_deleted") // 逻辑删除数据库中字段名
//                            .logicDeletePropertyName("isDeleted") // 逻辑删除实体类中的字段名
//                            .naming(NamingStrategy.underline_to_camel) // 表名 下划线 -》 驼峰命名
//                            .columnNaming(NamingStrategy.underline_to_camel) // 字段名 下划线 -》 驼峰命名
//                            .idType(IdType.ASSIGN_UUID) // 主键生成策略 雪花算法生成id
//                            .formatFileName("%sEntity") // Entity 文件名称
//                            .addTableFills(new Column("created_at", FieldFill.INSERT), new Column("updated_at", FieldFill.INSERT_UPDATE))//生成时间自动填充属性
//                            .controllerBuilder().enableRestStyle()//开启@RestController风格
//                            .serviceBuilder().formatServiceFileName("%sService"); //去掉默认的I前缀
//                })
//
////                //使用Freemarker引擎模板，默认的是Velocity引擎模板
////                .templateEngine(new VelocityTemplateEngine())
////                //设置自定义模板路径
////                .templateConfig(builder -> {
////                    builder.entity("/templates/entity.java.vm")
////                            .service("/templates/service.java.vm")
////                            .serviceImpl("/templates/serviceImpl.java.vm")
////                            .controller("/templates/controller.java.vm");
////                })
////
////                //注入配置————自定义模板
////                .injectionConfig(builder -> builder
////                        .beforeOutputFile((tableInfo, objectMap) -> {
////                            System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
////                        }) //输出文件之前消费者
////                        .customMap(Collections.singletonMap("my_field", "自定义配置 Map 对象")) //自定义配置 Map 对象
////                        .customFile(Collections.singletonMap("query.java", "/templates/query.java.vm")) //自定义配置模板文件
////                        .build()//加入构建队列
////                )
//
//                .execute();
//    }
}
