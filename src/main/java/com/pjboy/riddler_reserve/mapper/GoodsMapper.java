package com.pjboy.riddler_reserve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.model.GoodsDO;
import com.pjboy.riddler_reserve.model.util.DropDown;
import com.pjboy.riddler_reserve.model.vo.GoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<GoodsDO> {
  /**
   * <p>
   * 查询 : 根据state状态查询商品列表，分页显示
   * </p>
   *
   * @param page  分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
   * @param goodsName 名称
   * @param createTimeStart 创建时间起点
   * @param createTimeEnd 创建时间终点
   * @return 分页对象
   */
  IPage<GoodsVO> selectGoodsPage(Page<?> page, @Param("goodsName") String goodsName, @Param("createTimeStart") String createTimeStart, @Param("createTimeEnd") String createTimeEnd);

  /**
  * @Description: 获取下拉框
  * @Param: []
  * @return: java.util.List<com.pjboy.riddler_reserve.model.util.DropDown>
  * @Author: BLADE
  * @Date: 2021/10/20
  */
  List<DropDown> getAllDWGoods();
}
