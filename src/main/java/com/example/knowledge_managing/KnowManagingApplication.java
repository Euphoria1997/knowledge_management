package com.example.knowledge_managing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class KnowManagingApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowManagingApplication.class, args);}
//        FastAutoGenerator.create("jdbc:mysql://81.70.191.196/know_store", "visitor", "SduEduSE2035!")
//                .globalConfig(builder -> {
//                    builder.author("wenwen") // 设置作者
////                            .enableSwagger() // 开启 swagger 模式
////                            .fileOverride() // 覆盖已生成文件
//                            .outputDir("C:\\Users\\24042\\Desktop\\knowledge-manage\\src\\main\\java"); // 指定输出目录
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.example.knowledge_managing") // 设置父包名
////                            .moduleName("system") // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, "C:\\Users\\24042\\IdeaProjects\\knowledge-manage\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
//                })
//                .strategyConfig(builder -> {
//                    builder.addTablePrefix("sys_"); // 设置过滤表前缀
//                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .execute();
//    }

}
