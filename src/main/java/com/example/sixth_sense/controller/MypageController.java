package com.example.sixth_sense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MypageController {

    @RequestMapping("/")
    public String init() {
        return "mypage";
    }

    @RequestMapping("/review/")
    public String showReview() {
        return "review";
    }
}
