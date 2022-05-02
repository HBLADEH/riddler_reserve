package com.pjboy.riddler_reserve.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.vo.UserVO;
import com.pjboy.riddler_reserve.service.GoodsService;
import com.pjboy.riddler_reserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listAll")
    public AjaxResponse selectAllUser(@RequestParam(value = "size") Integer pageSize,
                                      @RequestParam(value = "page") Integer currentPage,
                                      @RequestParam(required = false) String username,
                                      @RequestParam(required = false) String nickname) {
        BasicCheck.checkRole("admin");
        String ErrorEmpty = "未查询到用户!";
        Page<UserVO> page = new Page<>(currentPage, pageSize);
        IPage<UserVO> userVOIPage = userService.selectUserPage(page, username, nickname);
        if (userVOIPage != null) return AjaxResponse.success(userVOIPage);
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
    }

    @DeleteMapping("")
    public AjaxResponse deleteUserByIds(@RequestBody List<Integer> ids) {
        BasicCheck.checkRole("admin");
        String ErrorDelete = "删除用户失败!";
        if (userService.deleteUserByIds(ids) > 0) return AjaxResponse.success();
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
    }
}
