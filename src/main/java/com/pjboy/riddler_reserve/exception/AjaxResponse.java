package com.pjboy.riddler_reserve.exception;

import lombok.Data;

/**
 * @program: ssy_back
 * @description: 接口数据统一响应数据结构
 * @author: BLADE
 * @create: 2020-10-25 00:39
 **/
@Data
public class AjaxResponse {
  private boolean result; // 是否请求成功
  private int code; // 请求响应代码
  private String message; // 请求结果描述信息
  private Object data; // 请求结果数据

  public AjaxResponse() {
  }

  /**
  * @Description: 请求异常的响应输出
  * @Param: 自定义异常
  * @return: 统一响应数据结构
  * @Author: BLADE
  * @Date: 2020/10/25
  */
  public static AjaxResponse error(CustomException e) {
    AjaxResponse resultBean = new AjaxResponse();
    resultBean.setResult(false);
    resultBean.setCode(e.getCode());
    resultBean.setMessage(e.getMessage());
    return  resultBean;
  }

  /**
   * @Description: 请求异常的响应输出
   * @Param: 自定义异常类型
   * @Param: 异常信息
   * @return: 统一响应数据结构
   * @Author: BLADE
   * @Date: 2020/10/25
   */
  public static AjaxResponse error(CustomExceptionType customExceptionType, String errorMessage) {
    AjaxResponse resultBean = new AjaxResponse();
    resultBean.setResult(false);
    resultBean.setCode(customExceptionType.getCode());
    resultBean.setMessage(errorMessage);
    return resultBean;
  }

  /**
  * @Description: 请求成功的通常响应,通常用于添加删除修改
  * @Param: []
  * @return: 统一响应数据结构
  * @Author: BLADE
  * @Date: 2020/10/25
  */
  public static AjaxResponse success() {
    AjaxResponse ajaxResponse = new AjaxResponse();
    ajaxResponse.setResult(true);
    ajaxResponse.setCode(200);
    ajaxResponse.setMessage("请求响应成功!");
    return ajaxResponse;
  }

  /**
  * @Description: 请求成功的响应,带有数据返回,常用于查询
  * @Param: 数据
  * @return: 统一响应数据结构
  * @Author: BLADE
  * @Date: 2020/10/25
  */
  public static AjaxResponse success(Object obj) {
    AjaxResponse ajaxResponse = new AjaxResponse();
    ajaxResponse.setResult(true);
    ajaxResponse.setCode(200);
    ajaxResponse.setMessage("请求响应成功!");
    ajaxResponse.setData(obj);
    return ajaxResponse;
  }

  /**
   * @Description: 请求成功的响应,带有数据返回,常用于查询
   * @Param: 数据
   * @return: 统一响应数据结构
   * @Author: BLADE
   * @Date: 2020/10/25
   */
  public static AjaxResponse success(Object obj, String message) {
    AjaxResponse ajaxResponse = new AjaxResponse();
    ajaxResponse.setResult(true);
    ajaxResponse.setCode(200);
    ajaxResponse.setMessage(message);
    ajaxResponse.setData(obj);
    return ajaxResponse;
  }

}
