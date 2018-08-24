package com.example.sixth_sense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MypageController {

    @GetMapping("/")
    public String init() {
        return "mypage";
    }

    @RequestMapping("/review/")
    public String showReview() {
        return "review";
    }
}
