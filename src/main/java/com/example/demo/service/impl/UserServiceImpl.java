package com.example.demo.service.impl;

import com.example.demo.common.IsMobilePhone;
import com.example.demo.common.RandomStr;
import com.example.demo.common.ResponseCode;
import com.example.demo.common.ServerResponse;
import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.IUserService;
import com.example.demo.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description
 * @author: X.Gao
 * @create: 2019-09-25 15:36
 **/

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse login() {

        return null;
    }

    @Override
    public ServerResponse register(User user, String passwordCheck) {

        /**
         * @Description: 实现用户注册功能
         * @Param: [user, passwordCheck]
         * @return: com.example.demo.common.ServerResponse
         * @Author: X.Gao
         */

        System.out.println("进入UserService的register方法");

        //参数校验
        if (user == null) {
            return ServerResponse.serverResponseByError(ResponseCode.PARAM_NOT_NULL, "参数不能为空");
        }

        //判断两次输入的密码是否一致
        if (!user.getPassword().equals(passwordCheck)) {
            return ServerResponse.serverResponseByError(ResponseCode.ERROR, "两次密码不同");
        }

        //判断注册的手机号是否符合要求
        if (!new IsMobilePhone().isMobilePhone(user.getTelephone())) {
            return ServerResponse.serverResponseByError(ResponseCode.ERROR, "手机号不符合规则");
        }

        //设置默认的用户ID
        user.setId("DemoUser_" + System.currentTimeMillis() + RandomStr.getRandomStr(4));

        //密码设置MD5加密
        user.setPassword(MD5Utils.getMD5Code(user.getPassword()));

        //判断用户ID是否重复
        if (userMapper.selectByPrimaryKey(user.getId()) != null) {
            return ServerResponse.serverResponseByError(ResponseCode.USERNAME_EXISTS, "用户已存在");
        }

        //判断用户名是否重复
/*        if (userMapper.selectByUsername(user.getUsername()) <= 0) {
            return ServerResponse.serverResponseByError(ResponseCode.USERNAME_EXISTS, "用户名已存在");
        }*/

        //在数据库中插入记录
        int insertResult = userMapper.insert(user);
        if (insertResult <= 0) {
            return ServerResponse.serverResponseByError(ResponseCode.ERROR, "注册失败");
        }

        return ServerResponse.serverResponseBySuccess();
    }
}
