package com.example.sixth_sense.mapper;


import com.example.sixth_sense.domain.WordList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WordListMapper {
    @Select("select * from wordlist")
    List<WordList> findAll();

    @Select("SELECT COUNT(id) FROM wordlist")
    int findCount();

    @Select("SELECT COUNT(*) FROM wordlist WHERE status = '1'")
    int findCountStatus();

    @Select("SELECT COUNT(*) FROM wordlist WHERE flicker= '1'")
    int findStudiedWord();


    @Select("select * from wordlist where id = #{id}")
    WordList findOne(Long id);


    @Insert("insert into wordlist (word, meaning, flicker,status,hatena,perfect) values (#{word}, #{meaning}, #{flicker},#{status},#{hatena},#{perfect})")
    @Options(useGeneratedKeys = true)
    void save(WordList wordlist);


    @Update("update wordlist set word = #{word}, meaning = #{meaning},flicker = #{flicker},status = #{status},hatena = #{hatena},perfect = #{perfect} where id = #{id}")
    void update(WordList wordlist);

    @Delete("delete from wordlist where id = #{id}")
    void delete(Long id);
}
