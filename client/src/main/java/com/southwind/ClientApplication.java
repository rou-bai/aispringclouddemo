package com.southwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //这个用来表示是feigin客户端
@ServletComponentScan  //这个用来服务跑起来检查filter
public class ClientApplication {
    public static void main(String[] args){
        SpringApplication.run(ClientApplication.class, args);
    }
}
