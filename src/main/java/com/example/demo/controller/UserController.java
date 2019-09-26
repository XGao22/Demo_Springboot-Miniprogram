package com.example.demo.controller;

import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description
 * @author: X.Gao
 * @create: 2019-09-25 15:29
 **/

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("register")
    public ServerResponse register(User user, String passwordCheck) {

        System.out.println("进入UserController的register方法");
        return userService.register(user, passwordCheck);
    }

}
