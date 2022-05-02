package com.pjboy.riddler_reserve.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.RoundDO;
import com.pjboy.riddler_reserve.model.util.DropDown;
import com.pjboy.riddler_reserve.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class RoundController {

    @Autowired
    private RoundService roundService;

    @GetMapping("/rounds/listAll")
    public AjaxResponse selectRoundsByList(@RequestParam(value = "size") Integer pageSize,
                                           @RequestParam(value = "page") Integer currentPage,
                                           @RequestParam(required = false) String name
    ) {
        BasicCheck.checkRole("admin");
        String ErrorEmpty = "未查询到房间!";
        Page<RoundDO> page = new Page<>(currentPage, pageSize);
        IPage<RoundDO> roundDOIPage = roundService.selectRoundsPage(page, name);
        if (roundDOIPage != null) return AjaxResponse.success(roundDOIPage);
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
    }

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

    @DeleteMapping("/rounds")
    public AjaxResponse deleteRound(@RequestBody List<Integer> ids) {
        String ErrorDelete = "删除场次失败!";
        BasicCheck.checkRole("admin");
        if (roundService.deleteRoundByIds(ids) > 0) return AjaxResponse.success();
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
    }

    @PutMapping("/rounds")
    public AjaxResponse updateRoundById(@RequestBody RoundDO roundDO) {
        String ErrorExist = "场次已存在!";
        String ErrorUpdate = "修改场次失败!";
        BasicCheck.checkRole("admin");
        if (roundService.checkRoundName(roundDO.getId(), roundDO.getName()))
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorExist);
        if (roundService.updateRound(roundDO) > 0) return AjaxResponse.success();
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorUpdate);
    }

    @GetMapping("/rounds/allDW")
    public AjaxResponse getAllDWRounds() {
        BasicCheck.checkRole("admin");
        String ErrorEmpty = "未查询到场次!";
        List<DropDown> dropDowns = roundService.getAllDWRounds();
        if (dropDowns != null) return AjaxResponse.success(dropDowns);
        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, ErrorEmpty);
    }
}

