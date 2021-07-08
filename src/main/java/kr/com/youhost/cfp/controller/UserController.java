package kr.com.youhost.cfp.controller;

import kr.com.youhost.cfp.dao.UserDao;
import kr.com.youhost.cfp.domain.UserVo;
import kr.com.youhost.cfp.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserLoginService userLoginService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/home/index");
        return mv;
    }

    @GetMapping("/user/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("frame", "no");
        String view = "/user/login";
        mv.setViewName(view);
        //mv.setViewName("/user/login");
        return mv;
    }

    @GetMapping("/user/logout")
    public ModelAndView logout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/home/index");
        return mv;
    }

    @GetMapping("/user/signup")
    public ModelAndView signup() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/signup");
        return mv;
    }

    @GetMapping("/api/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/login")
    public String login2(UserVo uservo) {
        List<UserVo> selectUserList = userLoginService.selectUserList(uservo);
        System.out.println("UserList" + selectUserList);
        return "/";
    }

}
