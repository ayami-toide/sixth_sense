package com.example.sixth_sense.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sense")
public class SenseController {

    @GetMapping()
    private String index(Model model){
        return "sense/mypage";
    }
}
