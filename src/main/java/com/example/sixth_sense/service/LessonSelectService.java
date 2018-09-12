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
    public LessonSelect update(Integer id){
        return lessonSelectMapper.update(id);
    }

}


