package com.pjboy.riddler_reserve.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @GetMapping("/hello")
  public String hello() {
    //System.out.println(StpUtil.hasRole("admin"));
    return "hello";
  }
}
