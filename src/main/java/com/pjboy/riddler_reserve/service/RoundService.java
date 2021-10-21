package com.pjboy.riddler_reserve.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.model.RoundDO;
import com.pjboy.riddler_reserve.model.util.DropDown;

import java.util.List;

public interface RoundService {
  int addRound(RoundDO roundDO);

  int deleteRoundById(Integer roundId);

  int deleteRoundByIds(List<Integer> ids);

  int updateRound(RoundDO roundDO);

  /**
   * @Description: 检查场次名称是否已经存在了
   * @Param: 场次名称
   * @return: 是否已经存在
   * @Author: BLADE
   * @Date: 2021/10/21
   */
  boolean checkRoundName(String roundName);

  RoundDO selectRoundById(Integer roundId);

  RoundDO selectRoundByName(String name);

  List<RoundDO> ListRounds();

  IPage<RoundDO> selectRoundsPage(Page<?> page, String name);

  List<DropDown> getAllDWRounds();
}
