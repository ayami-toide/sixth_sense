package com.example.sixth_sense.mapper;


import com.example.sixth_sense.domain.WordList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WordListMapper {
    @Select("select * from wordlist")
    List<WordList> findAll();
    //Osa
    @Select("SELECT COUNT(id) FROM wordlist")
    int findCount();
    //Osa
    @Select("SELECT COUNT(*) FROM wordlist WHERE status = '1'")
    int findCountStatus();
    //Osa
    @Select("SELECT COUNT(*) FROM wordlist WHERE flicker= '1'")
    int findStudiedWord();

    //Riku
    @Select("select * from wordlist where id = #{id}")
    WordList findOne(Long id);

    //Toy
    @Select("select word from wordlist  where id =#{id}")
    WordList findTestWord(Long id);

    //Toy
    @Select("select meaning from wordlist  where id =#{id}")
    WordList findTestMeaning(Long id);

    //Geeee Rina
    @Select("select * from wordlist where flicker = 0 LIMIT 5")
    List<WordList> findWords();

    //Geeee Rina
    @Update("update wordlist set status = 0 where word = #{word}")
    void flick_status_zero(String word);

    //Geeee Rina
    @Update("update wordlist set status = 1 where word = #{word}")
    void flick_status_ichi(String word);

    @Insert("insert into wordlist (word, meaning, flicker,status,hatena,perfect) values (#{word}, #{meaning}, #{flicker},#{status},#{hatena},#{perfect})")
    @Options(useGeneratedKeys = true)
    void save(WordList wordlist);


    @Update("update wordlist set word = #{word}, meaning = #{meaning},flicker = #{flicker},status = #{status},hatena = #{hatena},perfect = #{perfect} where id = #{id}")
    void update(WordList wordlist);

    @Delete("delete from wordlist where id = #{id}")
    void delete(Long id);
}
