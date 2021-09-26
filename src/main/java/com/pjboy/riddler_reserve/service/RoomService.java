package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.RoomDO;

import java.util.List;

public interface RoomService {
  int addRoom(RoomDO roomDO);

  int deleteRoomById(Integer roomId);

  int updateRoom(RoomDO roomDO);

  RoomDO selectRoomById(Integer roomId);

  RoomDO selectRoomByName(String name);

  List<RoomDO> ListRooms();
}
