package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortFolioController {
  
    
	
  @GetMapping(value = "/top")
  public String displayList(Model model) {

      return "top";
  }
  
  

  
  
  @RequestMapping("/signin")
  public String index() {
	  
    return "signin";
  }
  
  


}
