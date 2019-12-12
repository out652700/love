package com.word.wm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = {"com.word.wm.main.wm_dao"})
public class WmApplication {

    public static void main(String[] args) {
        SpringApplication.run(WmApplication.class, args);
    }

}
