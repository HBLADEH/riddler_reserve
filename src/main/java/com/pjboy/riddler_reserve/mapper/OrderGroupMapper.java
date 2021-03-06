package com.pjboy.riddler_reserve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.model.OrderGroupDO;
import com.pjboy.riddler_reserve.model.front.view.OrderGroupPlayerView;
import com.pjboy.riddler_reserve.model.vo.OrderGroupVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@Mapper
public interface OrderGroupMapper extends BaseMapper<OrderGroupDO> {
    /**
     * 分页查询组局列表
     *
     * @param page          分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)   * @param goodsName 商品名称
     * @param playTimeStart 创建时间起点
     * @param playTimeEnd   创建时间终点
     * @return 组局分页列表
     */
    IPage<OrderGroupVO> selectOrderGroupPage(Page<?> page, @Param("goodsName") String goodsName, @Param("playTimeStart") String playTimeStart, @Param("playTimeEnd") String playTimeEnd);

    /**
     * @Description: 根据 Id 获取组局数据
     * @Param: id
     * @return: 组局数据
     * @Author: BLADE
     * @Date: 2021/10/19
     */
    OrderGroupVO findOrderGroupById(@Param("id") Integer id);

    List<OrderGroupVO> listOrderGroupsByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<OrderGroupPlayerView> listOrderGroupsByFront(@Param("playTime") Date playTime,  @Param("goodsName") String goodsName,@Param("roomName") String roomName, @Param("roundName") String roundName);
}
