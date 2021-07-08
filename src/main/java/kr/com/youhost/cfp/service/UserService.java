package kr.com.youhost.cfp.service;

import kr.com.youhost.cfp.dao.UserDao;
import kr.com.youhost.cfp.dao.UserMapper;
import kr.com.youhost.cfp.domain.UserVo;
import kr.com.youhost.cfp.jpa.Authority;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


@Service
public class UserService {
    //private final UserRepository userRepository;
    private final UserMapper usermapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserMapper usermapper, PasswordEncoder passwordEncoder) {
        this.usermapper = usermapper;
        this.passwordEncoder = passwordEncoder;
    }

//    @Transactional
//    public User signup(UserVo userVo) {
//        if (usermapper.findbyId(userVo.getUserId()).orElse(null) != null) {
//            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
//        }
//
//        //빌더 패턴의 장점
//        Authority authority = Authority.builder()
//                .authorityName("ROLE_USER")
//                .build();
//
//        User user = User.builder()
//                .username(userVo.getUserId())
//                .password(passwordEncoder.encode(userVo.getPassword()))
//                .authorities((Collection<? extends GrantedAuthority>) Collections.singleton(authority))
//                .activated(true)
//                .build();
//
//        return userRepository.save(user);
//    }
//
//    @Transactional(readOnly = true)
//    public Optional<User> getUserWithAuthorities(String username) {
//        return userRepository.findOneWithAuthoritiesByUsername(username);
//    }
//
//    @Transactional(readOnly = true)
//    public Optional<User> getMyUserWithAuthorities() {
//        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
//    }



}
