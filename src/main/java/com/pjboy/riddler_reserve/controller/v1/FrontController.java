package com.pjboy.riddler_reserve.controller.v1;

import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.vo.InitVO;
import com.pjboy.riddler_reserve.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class FrontController {

  @Autowired
  private FrontService frontService;

  /**
  * @Description: 获取初始信息
  * @Param: []
  * @return: com.pjboy.riddler_reserve.exception.AjaxResponse
  * @Author: BLADE
  * @Date: 2021/5/20
  */
  @GetMapping("/init")
  public AjaxResponse getInit() {
    InitVO initVO = frontService.getInitData();
    if (initVO != null) return AjaxResponse.success(initVO);
    return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR,"获取初始信息失败!");
  }

}
