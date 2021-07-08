package kr.com.youhost.cfp.service;

import kr.com.youhost.cfp.dao.UserDao;
import kr.com.youhost.cfp.dao.UserMapper;
import kr.com.youhost.cfp.domain.UserVo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper usermapper;

    public CustomUserDetailsService(UserMapper usermapper) {
        this.usermapper = usermapper;
    }

    //DB에 접근하여 사용자 정보를 가져오는 역할
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userid) {
        UserVo user = usermapper.findbyId(userid).orElseThrow(() -> new UsernameNotFoundException(userid + " -> 데이터베이스에서 찾을 수 없습니다."));
        if(user.getUserId().equals(userid)) {
            new UsernameNotFoundException(userid + " -> 데이터베이스에서 찾을 수 없습니다.");
        }
        return new User(user.getUserId(), user.getUserPw());
//        return usermapper.findbyId(userid)
//                .orElseThrow(() -> new UsernameNotFoundException(userid + " -> 데이터베이스에서 찾을 수 없습니다."));
//                .map(user -> createUser(userid, user))

    }


    private User createUser(String username, UserVo user) {
        if(!user.getUseYn().equals("N")) {
            throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
        }
        return null;
//        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
//                .collect(Collectors.toList());
//        return new User(user.getUserId(),
//                user.getUserPw(),
//                grantedAuthorities);
    }

}