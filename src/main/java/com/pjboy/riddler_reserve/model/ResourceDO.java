package com.pjboy.riddler_reserve.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pjboy.riddler_reserve.model.util.ResourceTargetEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("rm_resource")
@NoArgsConstructor
public class ResourceDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id; // ID
    private String url; // 地址
    private Integer targetType; // 对应类型
    private Integer targetId; // 类型对应 ID

    public ResourceDO(String url, Integer targetType) {
        this.url = url;
        this.targetType = targetType;
    }
}
