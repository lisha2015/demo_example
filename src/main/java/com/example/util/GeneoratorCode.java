package com.example.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * 生成代码类
 */
public class GeneoratorCode {

    public static void main(String[] args) {

        String url = "jdbc:mysql://192.168.1.101:3306/ccii_redesign?useUnicode=true&characterEncoding=UTF-8&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "Ccii@562>c";

        String author = "lisha";
        String outputJavaDir = "E:\\git_osc\\hello\\src\\main\\java";
        String outputXmlDir = "E:\\git_osc\\hello\\src\\main\\resources\\mapper";
        String parentPackageName = "com.example";
        String moduleName = "";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(outputJavaDir); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(parentPackageName) // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, outputXmlDir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("shop_dict"); // 设置需要生成的表名
                    builder.entityBuilder().enableLombok(); // 使用 Lombok
                    builder.controllerBuilder().enableRestStyle(); // 使用 RestController
                    builder.serviceBuilder().formatServiceFileName("%sService"); // Service 接口命名格式
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}