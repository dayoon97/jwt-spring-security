//package kr.com.youhost.cfp.service;
//
//import kr.com.youhost.cfp.dao.UserDao;
//import kr.com.youhost.cfp.domain.UserVo;
//import kr.com.youhost.cfp.querydsl.repository.UserRepository;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.Collections;
//
//@Service
//public class UserService implements UserDetailsService {
//    //private final UserRepository userRepository;
//    private UserDao userdao;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserService(UserDao userdao, PasswordEncoder passwordEncoder) {
//        this.userdao = userdao;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Transactional
//    public User signup(UserVo userVo) {
//        if (userdao.findbyName(userVo.getUserNm()).orElse(null) != null) {
//            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
//        }
//
//        //빌더 패턴의 장점
//        Authority authority = Authority.builder()
//                .authorityName("ROLE_USER")
//                .build();
//
//        User user = User.builder()
//                .username(userDto.getUsername())
//                .password(passwordEncoder.encode(userDto.getPassword()))
//                .nickname(userDto.getNickname())
//                .authorities(Collections.singleton(authority))
//                .activated(true)
//                .build();
//
//        return userRepository.save(user);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDao.selectUser(username);
//        if(user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return null;
//    }
//
//    //DB에서 UserDetail을 얻어와 AuthenticationManager에게 제공하는 역할
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////
////        if (!username.equals("test")) throw new UsernameNotFoundException("해당 유저가 존재하지 않습니다.");
////
////        return new User();
////    }
//
//
//}
