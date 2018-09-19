package com.example.sixth_sense.mapper;

import com.example.sixth_sense.domain.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ResultMapper {

    @Update("update result set word_id = #{word_id} where id = #{id}")
    void result_update(Result result);
}
