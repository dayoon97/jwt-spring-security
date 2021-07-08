package kr.com.youhost.cfp.service;

import kr.com.youhost.cfp.dao.UserMapper;
import kr.com.youhost.cfp.domain.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService{
    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserVo> selectUserList(UserVo uservo) {
        return userMapper.selectUserList(uservo);
    }
}
