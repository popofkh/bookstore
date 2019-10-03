package edu.zju.cst.bookstore.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 方康华
 * @description 在Spring中装配MBG自动生成的mapper接口
 * 注解@Configuration表示这是一个Java配置文件，Spring容器会根据它来生成
 * IoC容器去装配Bean；注解@Mapper标注在mapper接口上表示将该接口作为Bean
 * 装配到IoC容器中；注解@MapperScan避免一一标注@Bean的麻烦，采用扫描方式
 * 将特定包中的所有mapper接口统一装配
 * @date 2019/8/9 8:29
 */
@Configuration
@MapperScan("edu.zju.cst.bookstore.mbg.mapper")
public class MyBatisConfig {
}

