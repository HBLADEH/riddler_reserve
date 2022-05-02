package com.pjboy.riddler_reserve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.model.OrderDO;
import com.pjboy.riddler_reserve.model.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<OrderDO> {
    List<OrderVO> listOrdersByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    IPage<OrderVO> getOrderVOByUserId(Page<?> page, @Param("userId") Integer userId, @Param("goodsName") String goodsName);

    IPage<OrderVO> getOrderListAll(Page<?> page, @Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("userName") String userName);
}
