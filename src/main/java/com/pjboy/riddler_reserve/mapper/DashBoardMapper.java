package com.pjboy.riddler_reserve.mapper;

import com.pjboy.riddler_reserve.model.vo.AfterViewsVO;
import com.pjboy.riddler_reserve.model.vo.DashBoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DashBoardMapper {
    DashBoardVO getDashBoardData();

    List<AfterViewsVO> getAfterViews();
}
