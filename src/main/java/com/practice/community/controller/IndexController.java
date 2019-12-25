package com.practice.community.controller;

import com.practice.community.dto.PaginationDTO;
import com.practice.community.dto.QuestionDTO;
import com.practice.community.mapper.UserMapper;
import com.practice.community.model.User;
import com.practice.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size){
        //实现user登陆过程中，通过cookie判断是否登陆
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }
        //实现主页问题列表，注入分页信息，page当前页，size当前页面包含的问题数
        PaginationDTO pagination = questionService.list(page, size);
        model.addAttribute("pagination", pagination);//通过model注入前端
        return "index";
    }
}
