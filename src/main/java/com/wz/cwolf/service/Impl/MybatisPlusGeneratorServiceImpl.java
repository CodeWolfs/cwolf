package com.wz.cwolf.service.Impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.wz.cwolf.service.MybatisPlusGeneratorService;
import com.wz.cwolf.vo.MybatisGenerateVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author WangZhe
 * @version 1.0
 * @className MybatisPlusGeneratorServiceImpl
 * @description mybatis 代码生成器
 * @date 2022/11/29 9:22
 */
@Service
@Slf4j
public class MybatisPlusGeneratorServiceImpl implements MybatisPlusGeneratorService {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    private static final String BASE_DIR = System.getProperty("user.dir");

    public MybatisPlusGeneratorServiceImpl() {
    }

    @Override
    public void generate(MybatisGenerateVo mybatisGenerateVo) {
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("wz") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .commentDate("yyyy-mm-dd")
                            .outputDir(BASE_DIR + "\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.wz.cwolf") // 设置父包名
//                            .moduleName("blog") //会显示在路径中
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.Impl")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, BASE_DIR + "\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(mybatisGenerateVo.getTableNameList()) // 设置需要生成的表名
                            .addTablePrefix("tb_", "c_") // 设置过滤表前缀
                            .serviceBuilder()
//                            .enableFileOverride()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()
//                            .enableFileOverride()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
//                            .enableFileOverride()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder()
//                            .enableFileOverride()
                            .enableBaseResultMap()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .mapperAnnotation(Mapper.class)
                            .formatMapperFileName("%sMapper");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
