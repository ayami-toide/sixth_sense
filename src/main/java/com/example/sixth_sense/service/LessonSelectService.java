package com.example.sixth_sense.service;

import com.example.sixth_sense.domain.LessonSelect;
import com.example.sixth_sense.domain.WordList;
import com.example.sixth_sense.mapper.LessonSelectMapper;
import com.example.sixth_sense.mapper.WordListMapper;
import com.example.sixth_sense.repository.LessonSelectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LessonSelectService {

    @Autowired
    private LessonSelectMapper lessonSelectMapper;

    @Transactional
    public LessonSelect findOne(Integer id){
        return lessonSelectMapper.findOne(id);
    }

    @Transactional
    public void update(LessonSelect lessonSelect){
       lessonSelectMapper.update(lessonSelect);
    }

    @Transactional
    public void update0(LessonSelect lessonSelect) { lessonSelectMapper.update0(lessonSelect);}

    @Transactional
    public void maru_update(LessonSelect lessonSelect){
        lessonSelectMapper.maru_update(lessonSelect);
    }

    @Transactional
    public void maru_update0(LessonSelect lessonSelect){
        lessonSelectMapper.maru_update0(lessonSelect);
    }

    @Transactional
    public int findPerfect(int lesson_id) { return lessonSelectMapper.findPerfect(lesson_id); }
}


