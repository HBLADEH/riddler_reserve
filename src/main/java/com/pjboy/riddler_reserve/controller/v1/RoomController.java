package com.pjboy.riddler_reserve.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.GoodsDO;
import com.pjboy.riddler_reserve.model.RoomDO;
import com.pjboy.riddler_reserve.service.GoodsService;
import com.pjboy.riddler_reserve.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/v1")
public class RoomController {

  @Autowired
  private RoomService roomService;

  @GetMapping("/rooms/listAll")
  public AjaxResponse selectRoomsByList(@RequestParam(value = "size") Integer pageSize,
                                        @RequestParam(value = "page") Integer currentPage,
                                        @RequestParam(required = false) String name
  ) {
    BasicCheck.checkRole("admin");
    String ErrorEmpty = "未查询到房间!";
    Page<RoomDO> page = new Page<>(currentPage,pageSize);
    IPage<RoomDO> roomDOIPage = roomService.selectRoomsPage(page,name);
    if (roomDOIPage != null) return AjaxResponse.success(roomDOIPage);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
  }

  @GetMapping("/rooms/{roomId}")
  public AjaxResponse selectRoomById(@PathVariable Integer roomId) {
    String ErrorSelect = "未找到该房间!";
    RoomDO roomDO = roomService.selectRoomById(roomId);
    if (roomDO != null) return AjaxResponse.success(roomDO);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorSelect);
  }

  @PostMapping("/rooms")
  public AjaxResponse addRoom(@RequestBody RoomDO roomDO) {
    String ErrorAdd = "添加房间失败!";
    String ErrorName = "该房间已存在!";
    BasicCheck.checkRole("admin");
    if (roomService.selectRoomByName(roomDO.getName()) != null)
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorName);
    if (roomService.addRoom(roomDO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorAdd);
  }

  @DeleteMapping("/rooms/{roomId}")
  public AjaxResponse deleteRoom(@PathVariable Integer roomId) {
    String ErrorDelete = "删除房间失败!";
    BasicCheck.checkRole("admin");
    if (roomService.deleteRoomById(roomId) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
  }

  @PutMapping("/rooms")
  public AjaxResponse updateRoomById(@RequestBody RoomDO roomDO) {
    String ErrorUpdate = "修改房间失败!";
    BasicCheck.checkRole("admin");
    if (roomService.updateRoom(roomDO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorUpdate);
  }
}

