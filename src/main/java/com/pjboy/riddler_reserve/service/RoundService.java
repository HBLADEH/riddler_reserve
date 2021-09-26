package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.RoomDO;
import com.pjboy.riddler_reserve.model.RoundDO;

import java.util.List;

public interface RoundService {
  int addRound(RoundDO roundDO);

  int deleteRoundById(Integer roundId);

  int updateRound(RoundDO roundDO);

  RoundDO selectRoundById(Integer roundId);
  RoundDO selectRoundByName(String name);
  List<RoundDO> ListRounds();

}
