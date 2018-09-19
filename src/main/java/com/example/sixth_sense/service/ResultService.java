package com.example.sixth_sense.service;

import com.example.sixth_sense.domain.Result;
import com.example.sixth_sense.mapper.ResultMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.spi.DirStateFactory;
import javax.transaction.Transactional;

@Service
public class ResultService {

    @Autowired
    private ResultMapper resultMapper;

    @Transactional
    public void result_update(Result result){ resultMapper.result_update(result);}

    @Transactional
    public Integer findWord(Integer id) {
        return resultMapper.findWord(id);
    }
}
