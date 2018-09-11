package com.example.sixth_sense.service;

import com.example.sixth_sense.domain.LessonSelect;
import com.example.sixth_sense.domain.WordList;
import com.example.sixth_sense.mapper.LessonSelectMapper;
import com.example.sixth_sense.mapper.WordListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LessonSelectService {

    @Autowired
    private LessonSelectMapper lessonSelectMapper;

    @Transactional
    public List<LessonSelect> findAll(){

        return lessonSelectMapper.findAll();
    }

    @Transactional
    public LessonSelect findOne(Long id){ return lessonSelectMapper.findOne(id); }

    @Transactional
    public void delete(Long id){ lessonSelectMapper.delete(id); }

    @Transactional
    public void save(LessonSelect lessonselect){ lessonSelectMapper.save(lessonselect); }

    @Transactional
    public void update(LessonSelect lessonselect){ lessonSelectMapper.update(lessonselect); }


}


