package com.example.sixth_sense.mapper;

import com.example.sixth_sense.domain.LessonSelect;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LessonSelectMapper {

    @Select("select * from lessonselect")
    List<LessonSelect> findAll();

    @Select("select * from lessonselect where id = #{id}")
    LessonSelect findOne(Long id);

    @Insert("insert into lessonselect (lesson_id,status) values (#{lesson_id}, #{status})")
    @Options(useGeneratedKeys = true)
    void save(LessonSelect lessonSelect);

    @Update("update lessonselect set status= 1 where lesson_id = #{id}")
    LessonSelect update(Integer id);

    @Delete("delete from lessonselect where id = #{id}")
    void delete(Long id);

}
