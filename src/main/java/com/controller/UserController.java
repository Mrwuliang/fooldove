package com.controller;

import com.bean.Province;
import com.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listener.WebApplicationContextUtils;
import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("quick")
    public String save1(){
        String a = new String("666");
        return "success";
    }

    @ResponseBody
    @RequestMapping("inputText")
    public String save2(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        String inputText = request.getParameter("inputText");
        ApplicationContext aa = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService userService = (UserService) aa.getBean("userService");
        Integer integer = userService.find(inputText);
        return String.valueOf(integer);
    }

    @ResponseBody
    @RequestMapping(value = "province",produces = "application/json;charset=utf-8")
    public List<Province> save3(HttpServletRequest request) throws JsonProcessingException {
        ServletContext servletContext = request.getServletContext();
        ApplicationContext aa = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService userService = (UserService) aa.getBean("userService");
        List<Province> province = userService.findProvince();
//        ObjectMapper json = (ObjectMapper) aa.getBean("json");
//        String s = json.writeValueAsString(province);
        return province;
    }

//    @ResponseBody
//    @RequestMapping
//    public User save4(){
//
//    }

}
