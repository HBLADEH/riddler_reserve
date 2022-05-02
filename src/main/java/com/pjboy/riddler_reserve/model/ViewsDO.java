package com.pjboy.riddler_reserve.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("rm_views")
public class ViewsDO {
    private Long views;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date viewDate;
}
