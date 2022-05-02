package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.mapper.UserMapper;
import com.pjboy.riddler_reserve.model.AdminDO;
import com.pjboy.riddler_reserve.model.UserDO;
import com.pjboy.riddler_reserve.model.vo.UserVO;
import com.pjboy.riddler_reserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public UserDO getById(Long id) {
        return userMapper.selectById(id);
    }


    @Override
    public UserDO checkLogin(String username, String password) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        UserDO userDO = userMapper.selectOne(queryWrapper);
        return userDO != null && encoder.matches(password, userDO.getPassword()) ? userDO : null;
    }

    @Override
    public boolean checkPassword(Integer id, String password) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        UserDO userDO = userMapper.selectOne(queryWrapper);
        return userDO != null && encoder.matches(password, userDO.getPassword());
    }

    @Override
    public boolean updatePassword(Integer id, String newPassword) {
        UserDO userDO = new UserDO();
        userDO.setId(id);
        userDO.setPassword(encoder.encode(newPassword));
        return userMapper.updateById(userDO) > 0;
    }

    @Override
    public boolean checkUsername(String username) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectList(queryWrapper).size() <= 0;
    }

    @Override
    public boolean checkNickname(String nickname) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nickname", nickname);
        return userMapper.selectList(queryWrapper).size() <= 0;
    }

    @Override
    public boolean doRegister(UserDO userDO) {
        userDO.setPassword(encoder.encode(userDO.getPassword()));
        return userMapper.insert(userDO) > 0;
    }

    @Override
    public UserVO getUserInfo(Integer userId) {
        return new UserVO(userMapper.selectById(userId));
    }

    @Override
    public IPage<UserVO> selectUserPage(Page<?> page, String username, String nickname) {
        return userMapper.selectUserPage(page, username, nickname);
    }

    @Override
    public int deleteUserByIds(List<Integer> ids) {
        return userMapper.deleteBatchIds(ids);
    }
}
