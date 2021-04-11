package com.pjboy.riddler_reserve.config;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import javax.swing.text.TabExpander;
import java.util.ArrayList;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {
  @Override
  public List<String> getPermissionList(Object loginId, String loginKey) {
    // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询权限
    /*
    List<String> list = new ArrayList<>();
    list.add("101");
    list.add("user-add");
    list.add("user-delete");
    list.add("user-update");
    list.add("user-get");
    list.add("article-get");
    return list;
    */
    return null;
  }
  
  
  /**
  * @Description: 只能做个简单的鉴权
  * @Param: [loginId, loginKey]
  * @return: java.util.List<java.lang.String>
  * @Author: BLADE
  * @Date: 2021/4/6
  */
  @Override
  public List<String> getRoleList(Object loginId, String loginKey) {
    String type = loginId.toString().substring(0, 5);
    List<String> list = new ArrayList<>();
    if (type.equals("users")) list.add("users");
    if (type.equals("admin")) list.add("admin");
    return list;
  }
}
