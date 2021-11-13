package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pjboy.riddler_reserve.mapper.GoodsMapper;
import com.pjboy.riddler_reserve.mapper.OrderMapper;
import com.pjboy.riddler_reserve.model.GoodsDO;
import com.pjboy.riddler_reserve.model.OrderDO;
import com.pjboy.riddler_reserve.model.vo.OrderVO;
import com.pjboy.riddler_reserve.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderDO getOrderById(Integer id) {
        return orderMapper.selectById(id);
    }

    @Override
    public List<OrderVO> listOrdersByDate(Date startTime, Date endTime) {
        return orderMapper.listOrdersByDate(startTime, endTime);
    }

    @Override
    public boolean checkOrderIsExist(Integer userId, Integer orderGroupId) {
        QueryWrapper<OrderDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("order_group", orderGroupId);
        return orderMapper.selectList(queryWrapper).size() > 0;
    }

    @Override
    public boolean checkOrderIsFull(Integer orderGroupId, Integer goodsId) {
        GoodsDO goodsDO = goodsMapper.selectById(goodsId);
        if (goodsDO != null) {
            QueryWrapper<OrderDO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("order_group", orderGroupId);
            Long orderCount = orderMapper.selectCount(queryWrapper);
            return orderCount >= goodsDO.getPlayNum();
        }
        return true;
    }

    @Override
    public boolean addOrder(OrderDO orderDO) {
        return orderMapper.insert(orderDO) > 0;
    }
}
