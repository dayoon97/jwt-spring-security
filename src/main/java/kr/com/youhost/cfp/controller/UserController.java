package kr.com.youhost.cfp.controller;

import kr.com.youhost.cfp.domain.User;
import kr.com.youhost.cfp.querydsl.entity.UserDto;
import kr.com.youhost.cfp.querydsl.repository.UserRepository;
import kr.com.youhost.cfp.service.UserService;
import kr.com.youhost.cfp.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    private UserService userService;

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

//    @PostMapping("/signup")
//    public Object newUser(@RequestParam Map<String, Object> param) {
//        //System.out.println(param.get("userId"));
//        //System.out.println(param.get("userPassword"));
//
//        //return "1";
//        //return userRepository.save(userDto);
//        //Map<String, Object> result = new HashMap<String, Object>();;
//        //System.out.println(param);
//        //result.put("code", "0000");
//        return userService.getUserName();
////        return "/home/index";
//    }

    @GetMapping("/api/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

//    @GetMapping("/permit-all")
//    public Object getTest() throws Exception {
//        return userService.getTest();
//    }
//
//    @GetMapping("/auth")
//    public Object getTest2() throws Exception {
//        return userService.getTest2();
//    }


}
