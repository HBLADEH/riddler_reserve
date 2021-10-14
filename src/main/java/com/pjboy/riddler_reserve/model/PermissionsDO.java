package com.pjboy.riddler_reserve.model;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("rm_permissions")
public class PermissionsDO {
  private Integer id;
  private String label;
  private String value;
}
