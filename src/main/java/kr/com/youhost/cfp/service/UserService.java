package kr.com.youhost.cfp.service;

import kr.com.youhost.cfp.domain.User;
import kr.com.youhost.cfp.querydsl.entity.UserDto;
import kr.com.youhost.cfp.querydsl.entity.UserRole;
import kr.com.youhost.cfp.querydsl.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Transactional
    public Long signUp(UserDto userDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDto.setUserPwd(passwordEncoder.encode(userDto.getUserPwd()));

        return userRepository.save(userDto.toEntity()).getUserId();
    }

    @Transactional
    public Long newUser(UserDto userDto) {
        return userRepository.save(userDto.toEntity()).getUserId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        //로그인을 하기 위해 가입된 user정보를 조회하는 메소드
//        Optional<User> userWrapper = userRepository.findByUserName(username);
//        User user = userWrapper.get();
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        if("admin".equals(username)){
//            System.out.println(username);
//            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
//        } else {
//            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
//        }
//
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPwd(), authorities);
//    }

    //DB에서 UserDetail을 얻어와 AuthenticationManager에게 제공하는 역할
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        if (!username.equals("test")) throw new UsernameNotFoundException("해당 유저가 존재하지 않습니다.");
//
//        return new ;
//    }


}
