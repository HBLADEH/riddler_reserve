package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.mapper.RoundMapper;
import com.pjboy.riddler_reserve.model.RoomDO;
import com.pjboy.riddler_reserve.model.RoundDO;
import com.pjboy.riddler_reserve.model.util.DropDown;
import com.pjboy.riddler_reserve.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundServiceImpl implements RoundService {

  @Autowired
  private RoundMapper roundMapper;

  @Override
  public int addRound(RoundDO roundDO) {
    return roundMapper.insert(roundDO);
  }

  @Override
  public int deleteRoundById(Integer roundId) {
    return roundMapper.deleteById(roundId);
  }

  @Override
  public int deleteRoundByIds(List<Integer> ids) {
    return roundMapper.deleteBatchIds(ids);
  }

  @Override
  public int updateRound(RoundDO roundDO) {
    return roundMapper.updateById(roundDO);
  }

  @Override
  public boolean checkRoundName(String roundName) {
    QueryWrapper<RoundDO> wrapper = new QueryWrapper<>();
    wrapper.eq("name", roundName);
    return roundMapper.selectList(wrapper).size() > 0;
  }

  @Override
  public RoundDO selectRoundById(Integer roundId) {
    return roundMapper.selectById(roundId);
  }

  @Override
  public RoundDO selectRoundByName(String name) {
    QueryWrapper<RoundDO> wrapper = new QueryWrapper<>();
    wrapper.eq("name", name);
    return roundMapper.selectOne(wrapper);
  }

  @Override
  public List<RoundDO> ListRounds() {
    return roundMapper.selectList(null);
  }

  @Override
  public IPage<RoundDO> selectRoundsPage(Page<?> page, String name) {
    return roundMapper.selectRoundsPage(page,name);
  }

  @Override
  public List<DropDown> getAllDWRounds() {
    return roundMapper.getAllDWRounds();
  }
}
