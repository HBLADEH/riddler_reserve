package com.pjboy.riddler_reserve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.model.GoodsDO;
import com.pjboy.riddler_reserve.model.UserDO;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserMapper extends BaseMapper<UserDO> {


}
