package com.example.sixth_sense.controller;


import com.example.sixth_sense.domain.WordList;
import com.example.sixth_sense.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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
    WordListService wordlistService;

    @GetMapping("test")
    public String test(Model model){
        return "test";
    }

    @GetMapping("mypage")
    public String mypage(Model model){
        model.addAttribute("count",wordlistService.findCount());
        model.addAttribute("status",wordlistService.findCountStatus());
//        model.addAttribute("studied",wordlistService.findStudiedWord());

        return "mypage";
    }

    @GetMapping("study")
    public String study(Model model){

        model.addAttribute("newWords1", wordlistService.findNewWords1());
        model.addAttribute("newWords2", wordlistService.findNewWords2());

        return "study";
    }

    @GetMapping("review")
    public String review(Model model){
        model.addAttribute("studying",wordlistService.findCountStudyingNow());
        model.addAttribute("perfect",wordlistService.findCountPerfect());
        model.addAttribute("countMaster",wordlistService.countMaster());

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

                String[] array = {"今日もおつかれ", "Excellent", "never give up", "君ならできる"};
                List<String> list = Arrays.asList(array);
                Collections.shuffle(list);
                String word  = list.get(1);
                array = (String[])list.toArray(new String[0]);
                model.addAttribute("word",word);

        model.addAttribute("words",wordlistService.findOne(new Long(1)));

        return "test_result";

    }

    @GetMapping("unit_select")
    public String unit_select(Model model){
        return "unit_select";
    }

    @GetMapping("teacher_unit_select")
    public String teacher_unit_select(Model model){

        String teacherId = "teacherId";
        model.addAttribute("teacherId",teacherId);

        return "unit_select";
    }

    @GetMapping("teacher_page")
    public String teacher_page(Model model){


        return "teacher_page";
    }

    @RequestMapping("get_ready_test")
    public String get_ready_test(Model model){

        int id = 2;
        model.addAttribute("nextId", id);
        model.addAttribute("words",wordlistService.findOne(new Long(1)));

        return "get_ready_test";
    }

    @GetMapping("wordlist")
    public String wordlist(Model model){
        model.addAttribute("ShowWordColumns",wordlistService.findAll());
        return "wordlist";
    }


    //osanai(9/11)
    @GetMapping("master")
    public String master(Model model){
        model.addAttribute("masters1",wordlistService.findMaster1());
        model.addAttribute("masters2",wordlistService.findMaster2());
        return "master";
    }




}