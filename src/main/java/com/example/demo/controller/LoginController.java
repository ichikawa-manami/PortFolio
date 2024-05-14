package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.UserAddRequest;

@Controller
public class LoginController {
	
    @GetMapping(value = "/user/login")
    public String displayLogin() {
        return "user/login";
    }
  
  @RequestMapping("/")
  @PreAuthorize("permitAll")
  public ModelAndView index(ModelAndView mav) {
    mav.setViewName("index");
    mav.addObject("title", "Index page");
    mav.addObject("msg", "This is top page.");
    return mav;
  }

  @RequestMapping("/user/top")
  @PreAuthorize("isAuthenticated()")
  public ModelAndView secret(ModelAndView mav) {
    mav.setViewName("Top");
    mav.addObject("title", "Top page");
    mav.addObject("msg", "This is top page.");
    return mav;
  }


  @RequestMapping("/user/login")
  @PreAuthorize("permitAll")
  public ModelAndView login(ModelAndView mav,
      @RequestParam(value="error", required=false)String error) {
    mav.setViewName("login");
    System.out.println(error);
    if (error != null) {
      mav.addObject("msg", "ログインできませんでした。");
    } else {
      mav.addObject("msg", "ユーザー名とパスワードを入力：");
    }
    return mav;
  }
  
}