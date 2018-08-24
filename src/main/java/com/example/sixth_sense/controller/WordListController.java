package com.example.sixth_sense.controller;

import com.example.sixth_sense.domain.WordList;
import com.example.sixth_sense.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/sense")
public class Controller {

    @Autowired
    private WordListService wordlistService;

    public String test(Model model){
      int a = 2;
      model.addAttribute("a",a);
      return "test";
  }






}
