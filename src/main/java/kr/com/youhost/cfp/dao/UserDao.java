package kr.com.youhost.cfp.dao;

import kr.com.youhost.cfp.domain.UserVo;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDao {

    public UserVo findbyName(String username) throws Exception {
        return selectOne(username, "user.findByName");
    }


}
