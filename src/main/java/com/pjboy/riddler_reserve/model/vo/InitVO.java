package com.pjboy.riddler_reserve.model.vo;

import com.pjboy.riddler_reserve.model.RoomDO;
import com.pjboy.riddler_reserve.model.RoundDO;
import lombok.Data;

import java.util.List;
@Data
public class InitVO {
  List<RoomDO> rooms;
  List<RoundDO> rounds;
}
