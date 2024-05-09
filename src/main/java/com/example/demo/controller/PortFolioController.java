package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserAddRequest;
import com.example.demo.service.PortFolioService;


@Controller
public class PortFolioController {
  
    @Autowired
    private PortFolioService portFolioService;
	
  @RequestMapping(value = "/top")
  public String displayList(Model model) {

      return "top";
  }
  
  

  
  
  @RequestMapping("/signin")
  public String index() {
	  
    return "signin";
  }
  
  
  /**
   * ユーザー新規登録
   * @param userRequest リクエストデータ
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @RequestMapping(value = "/signin", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute UserAddRequest userRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
          // 入力チェックエラーの場合
          List<String> errorList = new ArrayList<String>();
          for (ObjectError error : result.getAllErrors()) {
              errorList.add(error.getDefaultMessage());
          }
          model.addAttribute("validationError", errorList);
          return "user/add";
      }
      // ユーザー情報の登録
      portFolioService.save(userRequest);
      return "redirect:/user/list";
  }

}
