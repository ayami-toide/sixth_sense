package com.example.sixth_sense.controller;


import com.example.sixth_sense.domain.WordList;
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
    WordListService wordlistService;

    @GetMapping("test")
    public String test(Model model){
        return "test";
    }

    @GetMapping("mypage")
    public String mypage(Model model){
        model.addAttribute("count",wordlistService.findCount());
        model.addAttribute("status",wordlistService.findCountStatus());
        model.addAttribute("studied",wordlistService.findStudiedWord());

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
        model.addAttribute("status",wordlistService.findCountStatus());

        return "review";
    }

    @GetMapping("test_result")
    public String test_result(Model model) {
        return "test_result";
    }

    @GetMapping("study_index")
    public String study_index(Model model) {
        return "study_index";
    }

    @RequestMapping("test_quiz")
    public String test_quiz(Model model){

<<<<<<< HEAD
        String[] array = {"select * from wordlist where id = #{id}"};
        List<String> lists = Arrays.asList(array);
        Collections.shuffle(lists);
        String[] options =lists.toArray(new String[0]);



        // Collections.shuffle(wordlistService.findAll());

        int id = 2;
        model.addAttribute("nextId", id);
        model.addAttribute("words",wordlistService.findOne(new Long(1)));

        return "test_quiz";
    }

    @RequestMapping("test_question/{id}")
        public String test_question(@PathVariable("id") int id, Model model)
    {

        model.addAttribute("nextId", id + 1);
        model.addAttribute("words",wordlistService.findOne(new Long(id)));

        return "test_quiz" ;
    }

    @RequestMapping("test_result")
    public String test_result(Model model)
    {
        return "test_result";
=======
        String[] array = {"信じる", "嫌い", "遊ぶ", "かわいい", "TRUST"};
        List<String> list = Arrays.asList(array);
        String word = list.get(4);
        Collections.shuffle(list);
        String[] words =list.toArray(new String[0]);

        int id = 1;
        model.addAttribute("id", id);
        model.addAttribute("words",wordlistService.findOne(new Long(1)));

        return "test_quiz";
>>>>>>> 3bf4cfb684a31877faee48047d0c3bffeb75ca8e
    }



}






