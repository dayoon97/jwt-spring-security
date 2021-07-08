package kr.com.youhost.cfp.service;

import kr.com.youhost.cfp.domain.UserVo;

import java.util.List;

public interface UserLoginService {
    List<UserVo> selectUserList(UserVo uservo);
}
