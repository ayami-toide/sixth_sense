//package com.example.sixth_sense.controller;
//
//import com.example.sixth_sense.domain.WordList;
//import com.example.sixth_sense.service.WordListService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/sense")
//public class FlickerController {
//
//    @Autowired
//    WordListService wordListService;
//
////    @RequestMapping(value = "/study", method = RequestMethod.PUT)
////    public List<WordList> updateUnknown(String word) {
////        wordListService.flick_status_zero(word);
////
////    }
//
//    @RequestMapping(value = "/study", method = RequestMethod.PUT)
//    public List<WordList> updateKnown(String word) {
//        wordListService.flick_status_ichi(word);
//        List<WordList> allwords = wordListService.findAll();
//        return allwords;
//
//   }
//}
