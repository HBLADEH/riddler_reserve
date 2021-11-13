package com.pjboy.riddler_reserve.model.front.view;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("rm_order_group_player")
public class OrderGroupPlayerView {
    private Integer id;
    private String GoodsName;
    private Integer playNum;
    private Integer players;
    private String roomName;
    private String roundName;
    private String packageName;
    private BigDecimal packagePrice;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date playTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
