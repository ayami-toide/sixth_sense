package com.example.sixth_sense.controller;


import com.example.sixth_sense.domain.WordList;
import com.example.sixth_sense.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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
//    model.addAttribute("id", id);

        model.addAttribute("words",wordlistService.findWords());
        return "study";
    }

    @GetMapping("review")
    public String review(Model model){
        model.addAttribute("studying",wordlistService.findCountStudyingNow());
        model.addAttribute("perfect",wordlistService.findCountPerfect());

        return "review";
    }

    @GetMapping("study_index")
    public String study_index(Model model) {
        return "study_index";
    }

    @RequestMapping("test_quiz")
    public String test_quiz(Model model){

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

        if(id % 5 == 0){
            String lastid = "last";
            model.addAttribute("lastid",lastid);
        }
        return "test_quiz" ;
    }

    @RequestMapping("test_result/{id}")
    public String test_result(@PathVariable("id") int id,Model model)
    {
              int resultId1 = id - 5;
              model.addAttribute("testwords1",wordlistService.findTestWord(new Long(resultId1)));
              int resultId2 = id - 4;
              model.addAttribute("testwords2",wordlistService.findTestWord(new Long(resultId2)));
              int resultId3 = id - 3;
              model.addAttribute("testwords3",wordlistService.findTestWord(new Long(resultId3)));
              int resultId4 = id - 2;
              model.addAttribute("testwords4",wordlistService.findTestWord(new Long(resultId4)));
              int resultId5 = id - 1;
              model.addAttribute("testwords5",wordlistService.findTestWord(new Long(resultId5)));

              model.addAttribute("testmeanings1",wordlistService.findTestMeaning(new Long(resultId1)));
              model.addAttribute("testmeanings2",wordlistService.findTestMeaning(new Long(resultId2)));
              model.addAttribute("testmeanings3",wordlistService.findTestMeaning(new Long(resultId3)));
              model.addAttribute("testmeanings4",wordlistService.findTestMeaning(new Long(resultId4)));
              model.addAttribute("testmeanings5",wordlistService.findTestMeaning(new Long(resultId5)));

              model.addAttribute("id", id);

         return "test_result";
    }

    @GetMapping("unit_select")
    public String unit_select(Model model){
        return "unit_select";
    }

    @GetMapping("teacher_page")
    public String teacher_page(Model model){
        return "teacher_page";
    }

    @GetMapping("wordlist")
    public String wordlist(Model model){
        model.addAttribute("ShowWordColumns",wordlistService.findAll());
        return "wordlist";
    }



}

