package com.ryb.ashitaka.generator;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.ryb.ashitaka.common.base.BaseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodeGenerator {
    public static void main(String[] args) {
        List<String> tables = new ArrayList<>();
        tables.add("sys_log");
//        tables.add("p_question");
//        tables.add("p_answer");
//        tables.add("p_correct");

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/ashitaka","root","root")
                .globalConfig(builder -> {
                    builder.author("ryb")               //作者
                            .outputDir("D:\\mybatis-plus\\generator")    //输出路径(写到java目录)
                            .enableSwagger()           //开启swagger
                            .commentDate("yyyy-MM-dd")
                            .fileOverride();            //开启覆盖之前生成的文件

                })
                .packageConfig(builder -> {
                    builder.parent("com.ryb")
                            .moduleName("ashitaka")
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,"D:\\mybatis-plus\\generator\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            //.addTablePrefix("sys_")
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()
                            .superClass(BaseEntity.class)
                            .enableLombok()
                            .versionColumnName("version")
                            .logicDeleteColumnName("is_deleted")
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            // 映射路径使用连字符格式，而不是驼峰
                            .enableHyphenStyle()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder()
                            //生成通用的resultMap
                            .enableBaseResultMap()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()
                            .formatXmlFileName("%sMapper");
                })
                 // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}