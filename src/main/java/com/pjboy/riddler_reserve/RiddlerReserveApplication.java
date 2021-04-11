package com.pjboy.riddler_reserve;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pjboy.riddler_reserve.mapper")
public class RiddlerReserveApplication {

  public static void main(String[] args) {
    SpringApplication.run(RiddlerReserveApplication.class, args);
  }

}
