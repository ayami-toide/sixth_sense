package com.example.sixth_sense.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@WordListController
@RequestMapping("/sense")
class Controller {

    @GetMapping("test")
    public String test(Model model){
        model.addAttribute("a",a);
        return "test";
    }






}
