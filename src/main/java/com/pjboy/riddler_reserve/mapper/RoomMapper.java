package com.pjboy.riddler_reserve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.model.RoomDO;
import com.pjboy.riddler_reserve.model.util.DropDown;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomMapper extends BaseMapper<RoomDO> {
  IPage<RoomDO> selectRoomsPage(Page<?> page, @Param("name") String name);
  /**
   * @Description: 获取下拉框
   * @Param: []
   * @return: java.util.List<com.pjboy.riddler_reserve.model.util.DropDown>
   * @Author: BLADE
   * @Date: 2021/10/20
   */
  List<DropDown> getAllDWRooms();
}
