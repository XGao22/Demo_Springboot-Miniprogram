package com.example.demo.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: demo
 * @description 判断字符串是否为手机号，使用了Pattern的预编译功能
 * @author: X.Gao
 * @create: 2019-09-25 16:34
 **/
public class IsMobilePhone {

    private static final Pattern pattern = Pattern.compile("1\\d{10}");

    public boolean isMobilePhone(String telephone){

        return pattern.matcher(telephone).matches();
    }

}
