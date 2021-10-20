package com.pjboy.riddler_reserve.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.model.RoomDO;

import java.util.List;

public interface RoomService {
  int addRoom(RoomDO roomDO);

  int deleteRoomById(Integer roomId);

  int updateRoom(RoomDO roomDO);

  RoomDO selectRoomById(Integer roomId);

  RoomDO selectRoomByName(String name);

  List<RoomDO> ListRooms();

  IPage<RoomDO> selectRoomsPage(Page<?> page, String name);

}
