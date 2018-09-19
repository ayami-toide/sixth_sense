package com.example.sixth_sense.mapper;


import com.example.sixth_sense.domain.WordList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WordListMapper {
    @Select("select * from wordlist")
    List<WordList> findAll();

    @Select("select * from wordlist where id between 1 and 8 ORDER BY RAND() LIMIT 2")
    List<WordList> findTest0();

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

    //Toy
    @Select("select audio from wordlist  where id =#{id}")
    WordList findTestAudio(Long id);

    //Geeee Rina
    @Select("select word from wordlist where word = #{word}")
    String findByWord (String word);

    //Geeee Rina 9/11
    @Select("select * from wordlist where maru = 0 LIMIT 5")
    List<WordList> findNewWords1();

    //Geeee Rina 9/11
    @Select("select * from wordlist where maru = 0 LIMIT 5 OFFSET 5")
    List<WordList> findNewWords2();

    @Select("select * from wordlist where maru = 1 OR maru = 2 order by rand() limit 5")
    List<WordList> findReviewWords1();

    @Select("select * from wordlist where maru != 0 AND maru <= hatena order by rand() limit 5")
    List<WordList> findReviewWords2();

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

    //Osanai Master
    @Select("select * from wordlist where 0.5 < maru / (maru + hatena) && 2 <= maru order by maru + hatena desc")
    List<WordList> findMaster1();

    //Osanai Master
//    @Select("select * from wordlist where 0.5 < maru / (maru + hatena) && 2 <= maru LIMIT 5 OFFSET 5")
//    List<WordList> findMaster2();

    //osanai 9/18
    @Select("select * from wordlist where 0.5 < maru / (maru + hatena) && 2 <= maru && lesson = 'Get Ready' order by rand() LIMIT 5;")
    List<WordList> findMasterGetReady();

    @Select("select * from wordlist where 0.5 >= maru / (maru + hatena) && 2 > maru && lesson = 'Get Ready' order by rand() LIMIT 5")
    List<WordList> findStudyingGetReady();

    //osanai 9/18
    @Select("select * from wordlist where 0.5 < maru / (maru + hatena) && 2 <= maru && lesson = 'Lesson1' order by rand() LIMIT 5;")
    List<WordList> findMasterLesson1();

    @Select("select * from wordlist where 0.5 >= maru / (maru + hatena) && 2 > maru && lesson = 'Lesson1' order by rand() LIMIT 5")
    List<WordList> findStudyingLesson1();


    //Osanai Studying
    @Select("select * from wordlist where 0.5 >= maru / (maru + hatena) && 2 > maru order by rand() LIMIT 5")
    List<WordList> findStudying1();

    //Osanai Studying
    @Select("select * from wordlist where 0.5 >= maru / (maru + hatena) && 2 > maru LIMIT 5 OFFSET 5")
    List<WordList> findStudying2();

    //Osanai
    @Select("SELECT COUNT(*) FROM wordlist WHERE 0.5 < maru / (maru + hatena) && 2 <= maru")
    int countMaster();

    //Osanai
    @Select("SELECT COUNT(*) FROM wordlist WHERE 0.5 >= maru / (maru + hatena) && 2 > maru")
    int countStudying();

    //Osanai
    @Select("select * from wordlist where 0.5 < maru / (maru + hatena) && 2 <= maru")
    List<WordList> findMasterWordlist();

    //Osanai
    @Select("select * from wordlist where 0.5 >= maru / (maru + hatena) && 2 > maru")
    List<WordList> findStudyingWordlist();

    //Osanai
    @Select("select * from wordlist where 0 = maru")
    List<WordList> findNotStudied();

    @Select("select * from wordlist where id BETWEEN 1 AND 42 order by test_maru,rand() limit 5")
    List<WordList> setTest();

    @Select("select * from wordlist where id BETWEEN 43 AND 70 order by test_maru,rand() limit 5")
    List<WordList> setTest1();

    //Riku
    @Update("update wordlist set test_maru = test_maru+1 where id = #{id}")
    void test_maru_update(Integer id);
}
