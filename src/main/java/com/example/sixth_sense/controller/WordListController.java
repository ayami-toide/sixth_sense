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

        if(id % 5 == 0){
            String lastid = "last";
            model.addAttribute("lastid",lastid);
        }
        return "test_quiz" ;
    }

    @RequestMapping("test_result")
    public String test_result(Model model)
    {
        int id = 1;
        model.addAttribute("id", id);
        model.addAttribute("words",wordlistService.findOne(new Long(1)));

        for(int id =1; id<6; id++){
            switch(id){
                case 1: model.addAttribute("testwords1",wordlistService.findTestWord(new Long(id)));
                case 2: model.addAttribute("testwords2",wordlistService.findTestWord(new Long(id)));
                case 3: model.addAttribute("testwords3",wordlistService.findTestWord(new Long(id)));
                case 4: model.addAttribute("testwords4",wordlistService.findTestWord(new Long(id)));
                case 5: model.addAttribute("testwords5",wordlistService.findTestWord(new Long(id)));
            }
        }

        for(int id =1; id<6; id++){
            switch(id){
                case 1: model.addAttribute("testmeanings1",wordlistService.findTestMeaning(new Long(id)));
                case 2: model.addAttribute("testmeanings2",wordlistService.findTestMeaning(new Long(id)));
                case 3: model.addAttribute("testmeanings3",wordlistService.findTestMeaning(new Long(id)));
                case 4: model.addAttribute("testmeanings4",wordlistService.findTestMeaning(new Long(id)));
                case 5: model.addAttribute("testmeanings5",wordlistService.findTestMeaning(new Long(id)));
            }
        }


        model.addAttribute("words",wordlistService.findOne(new Long(1)));
        return "test_result";
    }



}

