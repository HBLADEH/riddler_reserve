package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.ViewsDO;

public interface ViewsService {

    /**
     * 根据日期获取 view
     *
     * @param Date 日期
     * @return view
     */
    ViewsDO getViewsByDate(String Date);

    /**
     * 根据日期修改 view
     *
     * @param views view
     * @param Date  日期
     * @return 是否成功
     */
    int updateViewsByDate(Long views, String Date);

    /**
     * 添加 veiw
     * @param Date  日期
     * @return 是否成功
     */
    int insertViews(String Date);

}
