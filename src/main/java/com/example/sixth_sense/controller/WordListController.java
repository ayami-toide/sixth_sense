package com.example.sixth_sense.controller;


import com.example.sixth_sense.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @RequestMapping("test_quiz")
    public String test_quiz(Model model){

        // List<String> toy =WordListService.findAll();

        String[] array = {"信じる", "嫌い", "遊ぶ", "かわいい", "TRUST"};
        List<String> list = Arrays.asList(array);
        String word = list.get(4);
        Collections.shuffle(list);
        String[] words =list.toArray(new String[0]);


        String m1 = list.get(0);
        String m2= list.get(1);
        String m3 = list.get(2);
        String m4 = list.get(3);

        model.addAttribute("word", word);
        model.addAttribute("m1", m1);
        model.addAttribute("m2", m2);
        model.addAttribute("m3", m3);
        model.addAttribute("m4", m4);
        model.addAttribute("words",wordlistService.findAll());
        return "test_quiz";


    }

    @RequestMapping("test_result")
    public String test_result(Model model)
    {

        return "test_result";
    }



}






