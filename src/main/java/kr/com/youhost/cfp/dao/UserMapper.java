package kr.com.youhost.cfp.dao;

import kr.com.youhost.cfp.domain.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<UserVo> findbyId(String userid);
    List<UserVo> selectUserList(UserVo uservo);
}
