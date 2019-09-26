package com.example.demo.common;

import java.util.Random;

/**
 * @program: demo
 * @description 生成随机位数的字符串
 * @author: X.Gao
 * @create: 2019-09-25 16:27
 **/
public class RandomStr {

    public static String getRandomStr(int length) {

        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        int randomNum;
        char randomChar;
        Random random = new Random();
        // StringBuffer类型的可以append增加字符
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < length; i++) {
            // 可生成[0,n)之间的整数，获得随机位置
            randomNum = random.nextInt(base.length());
            // 获得随机位置对应的字符
            randomChar = base.charAt(randomNum);
            // 组成一个随机字符串
            str.append(randomChar);
        }
        return str.toString();
    }

}
