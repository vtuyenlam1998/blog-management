package com.example.blogcrud.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.blogcrud.mapper")
public class MyBatisConfig {
}
