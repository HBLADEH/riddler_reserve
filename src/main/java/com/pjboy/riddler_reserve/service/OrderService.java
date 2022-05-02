package com.pjboy.riddler_reserve.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    /**
     * 根据 用户ID 获取订单
     *
     * @param userId    用户ID
     * @param goodsName 商品名称
     * @return 订单列表
     */
    IPage<OrderVO> getOrderVOByUserId(Page<?> page, Integer userId, String goodsName);


    IPage<OrderVO> getOrderListAll(Page<?> page, Date startTime, Date endTime, String userName);

    /**
     * 根据 Id 删除订单
     * @param orderId 订单 Id
     * @return 是否成功
     */
    boolean deleteOrderById(Integer orderId);

    /**
     * 检查 指定订单是否是指定用户的
     * @param orderId 订单 Id
     * @param userId 用户 Id
     * @return 订单是否为该用户
     */
    boolean checkOrderIsMy(Integer orderId, Integer userId);

    /**
     *  检查该订单是否可以删除
     * @param orderId 订单 Id
     * @return 是否可以删除
     */
    boolean checkOrderCanDelete(Integer orderId);
}
