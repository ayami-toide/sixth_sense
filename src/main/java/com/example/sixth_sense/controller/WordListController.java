package com.example.sixth_sense.controller;


import com.example.sixth_sense.domain.LessonSelect;
import com.example.sixth_sense.domain.WordList;
import com.example.sixth_sense.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.sixth_sense.service.LessonSelectService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;


@Controller
@RequestMapping("/sense")
public class WordListController {

    @Autowired
    LessonSelectService lessonSelectService;

    @Autowired
    WordListService wordlistService;


    @GetMapping("info")
    public String info(Model model) { return "info"; }


    @GetMapping("test")
    public String test(Model model){
        return "test";
    }

    @GetMapping("mypage")
    public String mypage(Model model){
        model.addAttribute("count",wordlistService.findCount());
        model.addAttribute("status",wordlistService.findCountStatus());

        return "mypage";
    }

    @GetMapping("study")
    public String study(Model model){

        model.addAttribute("newWords1", wordlistService.findNewWords1());
        model.addAttribute("newWords2", wordlistService.findNewWords2());
        model.addAttribute("reviewWords1", wordlistService.findReviewWords1());
        model.addAttribute("reviewWords2", wordlistService.findReviewWords2());

        return "study";
    }

    @GetMapping("review")
    public String review(Model model){
        model.addAttribute("studying",wordlistService.findCountStudyingNow());
        model.addAttribute("perfect",wordlistService.findCountPerfect());
        model.addAttribute("countMaster",wordlistService.countMaster());
        model.addAttribute("countStudying",wordlistService.countStudying());

        return "review";
    }


    @GetMapping("study_index")
    public String study_index(Model model) {
        return "study_index";
    }

    @RequestMapping("test_quiz")
    public String test_quiz(Model model){

        model.addAttribute("testNumber", 1);
        model.addAttribute("testwords",wordlistService.setTest());

        return "test_quiz";
    }

    @RequestMapping(value = "test_question/{id}/{testNumber}", method = POST)
    public  String post_test_question(@PathVariable("id") int id,@PathVariable("testNumber") int testNumber,@ModelAttribute WordList wordlist,Model model){

        wordlistService.test_maru_update(new Integer(id));

        model.addAttribute("testNumber",testNumber + 1);
        model.addAttribute("testwords",wordlistService.setTest());

        int TestNumber = testNumber + 1;
        if(TestNumber % 5 == 0){
            String lastid = "last";
            model.addAttribute("lastid",lastid);
        }
        return "test_quiz" ;
    }

    @RequestMapping(value = "test_question/{id}/{testNumber}", method = GET)
    public String test_question(@PathVariable("id") int id,@PathVariable("testNumber") int testNumber, Model model)
    {
        model.addAttribute("testNumber",testNumber + 1);
        model.addAttribute("testwords",wordlistService.setTest());
        int TestNumber = testNumber + 1;

        if(TestNumber % 5 == 0){
            String lastid = "last";
            model.addAttribute("lastid",lastid);
        }
        return "test_quiz" ;
    }


    @RequestMapping(value = "test_result/{id}" , method = POST)
    public String test_result_post(@PathVariable("id") int id,@ModelAttribute LessonSelect lessonSelect, Model model)
    {
        lessonSelect.setId(new Integer(0));
        lessonSelectService.perfect(lessonSelect);

        model.addAttribute("id", id);

        String[] array = {"Great job!", "Excellent!", "Well done!"};
        List<String> list = Arrays.asList(array);
        Collections.shuffle(list);
        String word  = list.get(1);
        array = (String[])list.toArray(new String[0]);

        model.addAttribute("word",word);

        return "test_result";


    }
    @RequestMapping(value = "test_result/{id}" , method = GET)
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

              //meaning
              model.addAttribute("testmeanings1",wordlistService.findTestMeaning(new Long(resultId1)));
              model.addAttribute("testmeanings2",wordlistService.findTestMeaning(new Long(resultId2)));
              model.addAttribute("testmeanings3",wordlistService.findTestMeaning(new Long(resultId3)));
              model.addAttribute("testmeanings4",wordlistService.findTestMeaning(new Long(resultId4)));
              model.addAttribute("testmeanings5",wordlistService.findTestMeaning(new Long(resultId5)));

              //audio
               model.addAttribute("testaudios1",wordlistService.findTestAudio(new Long(1)));
               model.addAttribute("testaudios2",wordlistService.findTestAudio(new Long(resultId2)));
               model.addAttribute("testaudios3",wordlistService.findTestAudio(new Long(resultId3)));
              model.addAttribute("testaudios4",wordlistService.findTestAudio(new Long(resultId4)));
              model.addAttribute("testaudios5",wordlistService.findTestAudio(new Long(resultId5)));


        model.addAttribute("id", id);

        String[] array = {"Great job!", "Excellent!", "Well done!"};
        List<String> list = Arrays.asList(array);
        Collections.shuffle(list);
        String word  = list.get(1);
        array = (String[])list.toArray(new String[0]);
        model.addAttribute("word",word);
        model.addAttribute("words",wordlistService.findOne(new Long(1)));

        return "test_result";

    }

    @GetMapping("teacher_unit_select")
    public String teacher_unit_select(Model model){

        model.addAttribute("status1",lessonSelectService.findOne(new Integer(1)));
        model.addAttribute("status2",lessonSelectService.findOne(new Integer(2)));
        model.addAttribute("status3",lessonSelectService.findOne(new Integer(3)));

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
        model.addAttribute("StudyingWordlists",wordlistService.findStudyingWordlist());
        model.addAttribute("MasterWordlists",wordlistService.findMasterWordlist());
        model.addAttribute("notstudieds",wordlistService.findNotStudied());
        return "wordlist";
    }


    //osanai(9/11)
    @GetMapping("master")
    public String master(Model model){
        model.addAttribute("masters1",wordlistService.findMaster1());
        model.addAttribute("masters2",wordlistService.findMaster2());
        model.addAttribute("reviewWords1", wordlistService.findReviewWords1());
        model.addAttribute("reviewWords2", wordlistService.findReviewWords2());
        return "master";
    }

    @GetMapping("unit_select")
    public String unit_select(Model model){

        model.addAttribute("status1",lessonSelectService.findOne(new Integer(1)));
        model.addAttribute("status2",lessonSelectService.findOne(new Integer(2)));
        model.addAttribute("status3",lessonSelectService.findOne(new Integer(3)));

        return "unit_select";
    }

    //osanai(9/12)
    @GetMapping("studying")
    public String studying(Model model){
        model.addAttribute("studyings1",wordlistService.findStudying1());
        model.addAttribute("studyings2",wordlistService.findStudying2());
        model.addAttribute("reviewWords1", wordlistService.findReviewWords1());
        model.addAttribute("reviewWords2", wordlistService.findReviewWords2());

        return "studying";
    }

    //osanai(9/12)
    @GetMapping("exam")
    public String exam(Model model){
        model.addAttribute("masters1",wordlistService.findMaster1());
        model.addAttribute("studyings1",wordlistService.findStudying1());
        model.addAttribute("StudyingWordlists",wordlistService.findStudyingWordlist());
        model.addAttribute("MasterWordlists",wordlistService.findMasterWordlist());
        model.addAttribute("notstudieds",wordlistService.findNotStudied());

        return "exam";
    }

    @GetMapping("exam2")
    public String exam2(Model model){
        model.addAttribute("masters1",wordlistService.findMaster1());
        model.addAttribute("studyings1",wordlistService.findStudying1());
        return "exam2";
    }

    @GetMapping("exam_get_ready")
    public String exam_get_ready(Model model){
        model.addAttribute("MasterGetReadys",wordlistService.findMasterGetReady());
        model.addAttribute("StudyingGetReadys",wordlistService.findStudyingGetReady());
        return "exam_get_ready";
    }

    @GetMapping("exam_lesson")
    public String exam_lesson(Model model){
        model.addAttribute("MasterLesson1",wordlistService.findMasterLesson1());
        model.addAttribute("StudyingLesson1",wordlistService.findStudyingLesson1());
        return "exam_lesson";
    }

    //osanai(9/12)
    @GetMapping("test01")
    public String test01(Model model){
        model.addAttribute("MasterWordlists",wordlistService.findMasterWordlist());
        return "test01";
    }


    @PutMapping("unit_select/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute LessonSelect lessonSelect,Model model) {

        lessonSelect.setId(id);
        lessonSelectService.update(lessonSelect);
        model.addAttribute("status1",lessonSelectService.findOne(new Integer(1)));
        model.addAttribute("status2",lessonSelectService.findOne(new Integer(2)));
        model.addAttribute("status3",lessonSelectService.findOne(new Integer(3)));


        String teacherId = "teacherId";
        model.addAttribute("teacherId",teacherId);
        return "unit_select";
    }

    @PutMapping("unit_select0/{id}")
    public String update0(@PathVariable Integer id, @ModelAttribute LessonSelect lessonSelect, Model model){

        lessonSelect.setId(id);
        lessonSelectService.update0(lessonSelect);
        model.addAttribute("status1",lessonSelectService.findOne(new Integer(1)));
        model.addAttribute("status2",lessonSelectService.findOne(new Integer(2)));
        model.addAttribute("status3",lessonSelectService.findOne(new Integer(3)));


        String teacherId = "teacherId";
        model.addAttribute("teacherId",teacherId);

        return "unit_select";
    }


    @PutMapping("unit_select_maru/{id}")
    public String maru_update(@PathVariable Integer id, @ModelAttribute LessonSelect lessonSelect,Model model) {

        lessonSelect.setId(id);
        lessonSelectService.maru_update(lessonSelect);
        model.addAttribute("status1",lessonSelectService.findOne(new Integer(1)));
        model.addAttribute("status2",lessonSelectService.findOne(new Integer(2)));
        model.addAttribute("status3",lessonSelectService.findOne(new Integer(3)));


        String teacherId = "teacherId";
        model.addAttribute("teacherId",teacherId);
        return "unit_select";
    }


    @PutMapping("unit_select_maru0/{id}")
    public String maru_update0(@PathVariable Integer id, @ModelAttribute LessonSelect lessonSelect,Model model) {

        lessonSelect.setId(id);
        lessonSelectService.maru_update0(lessonSelect);
        model.addAttribute("status1",lessonSelectService.findOne(new Integer(1)));
        model.addAttribute("status2",lessonSelectService.findOne(new Integer(2)));
        model.addAttribute("status3",lessonSelectService.findOne(new Integer(3)));

        String teacherId = "teacherId";
        model.addAttribute("teacherId",teacherId);
        return "unit_select";
    }

}