package com.example.demo.service;

import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description
 * @author: X.Gao
 * @create: 2019-09-25 15:36
 **/

public interface IUserService {

    ServerResponse login();

    ServerResponse register(User user, String passwordCheck);

}
