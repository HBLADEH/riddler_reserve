package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.OrderDO;
import com.pjboy.riddler_reserve.model.vo.OrderVO;

import javax.swing.text.StyledEditorKit;
import java.util.Date;
import java.util.List;

public interface OrderService {
    OrderDO getOrderById(Integer id);

    List<OrderVO> listOrdersByDate(Date startTime, Date endTime);

    boolean checkOrderIsExist(Integer userId, Integer orderGroupId);

    /**
     * 确认组局是否已经满了
     *
     * @param goodsId 商品 ID
     * @return 是否满了
     */
    boolean checkOrderIsFull(Integer orderGroupId, Integer goodsId);

    /**
     * 添加订单
     *
     * @param orderDO 订单信息
     * @return 是否成功
     */
    boolean addOrder(OrderDO orderDO);
}
