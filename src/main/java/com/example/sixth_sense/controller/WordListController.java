package com.example.sixth_sense.controller;


import com.example.sixth_sense.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/sense")
public class WordListController {

    @Autowired
     private WordListService wordlistService;

    @GetMapping("test")
    public String test(Model model){
        return "test";
    }

    @GetMapping("mypage")
    public String mypage(Model model){
        return "mypage";
    }

    @GetMapping("study")
    public String study(Model model){
//        model.addAttribute("id", id);

        model.addAttribute("words",wordlistService.findWords());
        return "study";
    }

    @GetMapping("review")
    public String review(Model model){
        return "review";
    }

    @GetMapping("test_result")
    public String test_result(Model model) {
        return "test_result";
    }


    @RequestMapping("test_quiz")
    public String test_quiz(Model model){

        String[] array = {"信じる", "嫌い", "遊ぶ", "かわいい", "TRUST"};
        List<String> list = Arrays.asList(array);
        String word = list.get(4);
        Collections.shuffle(list);
        String[] words =list.toArray(new String[0]);

        int id = 1;
        model.addAttribute("id", id);
        model.addAttribute("words",wordlistService.findOne(new Long(1)));

        return "test_quiz";
    }



}






