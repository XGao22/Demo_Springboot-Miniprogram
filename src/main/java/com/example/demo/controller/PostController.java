package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.ManualReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @program: demo
 * @description  测试接收POST请求，解析请求报文
 * @author: X.Gao
 * @create: 2019-07-29 10:52
 **/

@RestController
@RequestMapping("/test/")
public class PostController {

    @Autowired
    ManualReport manualReport;

    @RequestMapping(value = "/post.do", method = RequestMethod.POST)
    public void hello(HttpServletRequest request) {

        StringBuffer sb = new StringBuffer();

        try {
            BufferedReader br = request.getReader();
            String s = null;
            while((s=br.readLine())!=null){
                sb.append(s);
            }
            System.out.println(sb.toString());
            JSONObject jsonObject = JSONObject.parseObject(sb.toString());
            String epcCode = jsonObject.getString("epcCode");
            String staCode = jsonObject.getString("staCode");
            String flag = jsonObject.getString("flag");
            String datetime = jsonObject.getString("datetime");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
