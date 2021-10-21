package com.pjboy.riddler_reserve.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.model.RoomDO;
import com.pjboy.riddler_reserve.model.util.DropDown;

import java.util.List;

public interface RoomService {
  int addRoom(RoomDO roomDO);

  int deleteRoomById(Integer roomId);

  /**
  * @Description: 检查房间名称是否已经存在了
  * @Param: 房间名称
  * @return: 是否已经存在
  * @Author: BLADE
  * @Date: 2021/10/21
  */
  boolean checkRoomName(String roomName);

  int deleteRoomByIds(List<Integer> ids);

  int updateRoom(RoomDO roomDO);

  RoomDO selectRoomById(Integer roomId);

  RoomDO selectRoomByName(String name);

  List<RoomDO> ListRooms();

  IPage<RoomDO> selectRoomsPage(Page<?> page, String name);

  List<DropDown> getAllDWRooms();
}
