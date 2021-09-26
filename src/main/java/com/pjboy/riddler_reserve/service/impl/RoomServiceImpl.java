package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pjboy.riddler_reserve.mapper.RoomMapper;
import com.pjboy.riddler_reserve.model.RoomDO;
import com.pjboy.riddler_reserve.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

  @Autowired
  private RoomMapper roomMapper;


  @Override
  public int addRoom(RoomDO roomDO) {
    return roomMapper.insert(roomDO);
  }

  @Override
  public int deleteRoomById(Integer roomId) {
    return roomMapper.deleteById(roomId);
  }

  @Override
  public int updateRoom(RoomDO roomDO) {
    return roomMapper.updateById(roomDO);
  }

  @Override
  public RoomDO selectRoomById(Integer roomId) {
    return roomMapper.selectById(roomId);
  }

  @Override
  public RoomDO selectRoomByName(String name) {
    QueryWrapper<RoomDO> wrapper = new QueryWrapper<>();
    wrapper.eq("name", name);
    return roomMapper.selectOne(wrapper);
  }

  @Override
  public List<RoomDO> ListRooms() {
    return roomMapper.selectList(null);
  }
}
