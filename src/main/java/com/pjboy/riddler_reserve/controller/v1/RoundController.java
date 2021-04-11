package com.pjboy.riddler_reserve.controller.v1;

import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.mapper.RoundMapper;
import com.pjboy.riddler_reserve.model.RoomDO;
import com.pjboy.riddler_reserve.model.RoundDO;
import com.pjboy.riddler_reserve.service.RoomService;
import com.pjboy.riddler_reserve.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.RoundingMode;

@RestController
@RequestMapping("/v1")
public class RoundController {

  @Autowired
  private RoundService roundService;

  @GetMapping("/rounds/{roundId}")
  public AjaxResponse selectRoundById(@PathVariable Integer roundId) {
    String ErrorSelect = "未找到该场次!";
    RoundDO roundDO = roundService.selectRoundById(roundId);
    if (roundDO != null) return AjaxResponse.success(roundDO);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorSelect);
  }

  @PostMapping("/rounds")
  public AjaxResponse addRound(@RequestBody RoundDO roundDO) {
    String ErrorAdd = "添加场次失败!";
    String ErrorName = "该场次已存在!";
    BasicCheck.checkRole("admin");
    if (roundService.selectRoundByName(roundDO.getName()) != null)
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorName);
    if (roundService.addRound(roundDO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorAdd);
  }

  @DeleteMapping("/rounds/{roundId}")
  public AjaxResponse deleteRound(@PathVariable Integer roundId) {
    String ErrorDelete = "删除场次失败!";
    BasicCheck.checkRole("admin");
    if (roundService.deleteRoundById(roundId) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
  }

  @PutMapping("/rounds")
  public AjaxResponse updateRoundById(@RequestBody RoundDO roundDO) {
    String ErrorUpdate = "修改场次失败!";
    BasicCheck.checkRole("admin");
    if (roundService.updateRound(roundDO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorUpdate);
  }
}

