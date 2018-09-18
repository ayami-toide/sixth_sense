package com.example.sixth_sense.mapper;

import com.example.sixth_sense.domain.LessonSelect;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LessonSelectMapper {

    @Select("select * from lessonselect")
    List<LessonSelect> findAll();

    @Select("select * from lessonselect where id = #{id}")
    LessonSelect findOne(Integer id);

    @Insert("insert into lessonselect (lesson_id,status) values (#{lesson_id}, #{status})")
    @Options(useGeneratedKeys = true)
    void save(LessonSelect lessonSelect);

    @Update("update lessonselect set status= 1 where lesson_id = #{id}")
    void update(LessonSelect lessonSelect);

    @Update("update lessonselect set status= 0 where lesson_id = #{id}")
    void update0 (LessonSelect lessonSelect);

    @Update("update lessonselect set maru_status= 1 where lesson_id = #{id}")
    void maru_update(LessonSelect lessonSelect);

    @Update("update lessonselect set maru_status= 0 where lesson_id = #{id}")
    void maru_update0(LessonSelect lessonSelect);

    @Update("update lessonselect set perfect = perfect + 1 where lesson_id = #{id} ")
    void perfect(LessonSelect lessonSelect);

    @Delete("delete from lessonselect where id = #{id}")
    void delete(Long id);

}
