package com.example.sixth_sense.controller;

import com.example.sixth_sense.bean.StudyBean;
import com.example.sixth_sense.domain.WordList;
import com.example.sixth_sense.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/sense")
public class FlickerController {

    @Autowired
    WordListService wordListService;
    @RequestMapping(value = "/study1", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void update_flicker(@RequestBody StudyBean bean) {
        wordListService.flicker_increment(bean.getWord());
    }
}
