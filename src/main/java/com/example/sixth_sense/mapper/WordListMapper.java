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
    @Select("SELECT COUNT(*) FROM wordlist WHERE maru = '1'")
    int findCountStatus();
    //Osa
//    @Select("SELECT COUNT(*) FROM wordlist WHERE flicker= '1'")
//    int findStudiedWord();

    @Select("SELECT COUNT(*) FROM wordlist WHERE perfect= '1'")
    int findCountStudyingNow();

    @Select("SELECT COUNT(*) FROM wordlist WHERE perfect= '2'")
    int findCountPerfect();

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
    @Select("select word from wordlist where word = #{word}")
    String findByWord (String word);

    //Geeee Rina 9/11
    @Select("select * from wordlist where maru = 0 LIMIT 5")
    List<WordList> findNewWords1();

    //Geeee Rina 9/11
    @Select("select * from wordlist where maru = 0 LIMIT 5 OFFSET 5")
    List<WordList> findNewWords2();

    //Geeee Rina
    @Update("UPDATE wordlist SET maru = maru + 1 WHERE word = #{word}")
    void maru_increment(String word);

    //Geeee Rina
    @Update("UPDATE wordlist SET hatena = hatena + 1 WHERE word = #{word}")
    void hatena_increment(String word);

    @Insert("insert into wordlist (word, meaning, flicker,status,hatena,perfect) values (#{word}, #{meaning}, #{flicker},#{status},#{hatena},#{perfect})")
    @Options(useGeneratedKeys = true)
    void save(WordList wordlist);


    @Update("update wordlist set word = #{word}, meaning = #{meaning},flicker = #{flicker},status = #{status},hatena = #{hatena},perfect = #{perfect} where id = #{id}")
    void update(WordList wordlist);

    @Delete("delete from wordlist where id = #{id}")
    void delete(Long id);

    //Osanai
    @Select("select * from wordlist where 0.5 < maru / (maru + hatena) && 2 <= maru LIMIT 5")
    List<WordList> findMaster1();

    //Osanai
    @Select("select * from wordlist where 0.5 < maru / (maru + hatena) && 2 <= maru LIMIT 5 OFFSET 5")
    List<WordList> findMaster2();

    @Select("SELECT COUNT(*) FROM wordlist WHERE 0.5 < maru / (maru + hatena) && 2 <= maru")
    int countMaster();

}
