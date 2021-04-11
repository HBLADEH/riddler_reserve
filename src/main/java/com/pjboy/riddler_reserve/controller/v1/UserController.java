package com.pjboy.riddler_reserve.controller.v1;

import com.pjboy.riddler_reserve.model.UserDO;
import com.pjboy.riddler_reserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 用户控制器
 * @Author: BLADE
 * @Date: 2021/4/5
 */
@RestController
@RequestMapping("/v1")
public class UserController {

  @Autowired
  private UserService userService;

  //@GetMapping("/users/{id}")
  //public UserDO getUserById(@PathVariable Long id) {
  //  return userService.getById(id);
  //}
}
