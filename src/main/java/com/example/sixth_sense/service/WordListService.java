package com.example.sixth_sense.service;


import com.example.sixth_sense.domain.WordList;
import com.example.sixth_sense.mapper.WordListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WordListService {

        @Autowired
        private WordListMapper wordListMapper;

        //Geeee Rina
        @Transactional
        public List<WordList> findNewWords1(){ return wordListMapper.findNewWords1(); }

        //Geeee Rina
        @Transactional
        public List<WordList> findNewWords2(){ return wordListMapper.findNewWords2(); }

        @Transactional
        public WordList findTestWord(Long id){ return wordListMapper.findTestWord(id); }

        @Transactional
        public WordList findTestMeaning(Long id){
        return wordListMapper.findTestMeaning(id);

    }


        @Transactional
        public List<WordList> findAll(){

            return wordListMapper.findAll();
        }

        @Transactional
        public WordList findOne(Long id){ return wordListMapper.findOne(id); }

        @Transactional
        public  int findCount(){
            return wordListMapper.findCount();
        }

        @Transactional
        public  int findCountStatus(){
            return wordListMapper.findCountStatus();
        }

//        @Transactional
//        public  int findStudiedWord(){
//            return wordListMapper.findStudiedWord();
//        }

        @Transactional
        public  int findCountStudyingNow(){
            return wordListMapper.findCountStudyingNow();
        }

        @Transactional
        public  int findCountPerfect(){ return wordListMapper.findCountPerfect(); }

        //Osanai(9/11)
        @Transactional
        public List<WordList> findMaster1(){ return wordListMapper.findMaster1(); }

        //Osanai(9/11)
        @Transactional
        public List<WordList> findMaster2(){ return wordListMapper.findMaster2(); }

        //Osanai(9/11)
        @Transactional
        public  int countMaster(){
            return wordListMapper.countMaster();
        }

        //Osanai
        @Transactional
        public List<WordList> findStudied(){ return wordListMapper.findStudied(); }

        //Osanai
        @Transactional
        public List<WordList> findNotStudied(){ return wordListMapper.findNotStudied(); }




        @Transactional
        public void save(WordList wordlist){ wordListMapper.save(wordlist); }

        @Transactional
        public void update(WordList wordlist){ wordListMapper.update(wordlist); }

        //Geeee Rina
        @Transactional
        public void findByWord(String word){ wordListMapper.findByWord(word); }

        //Geeee Rina
        @Transactional
        public void maru_increment(String word){

            wordListMapper.maru_increment(word);
        }

        //Geeee Rina
        @Transactional

        public void hatena_increment(String word){

            wordListMapper.hatena_increment(word);
        }


        @Transactional
        public void delete(Long id){ wordListMapper.delete(id); }

}
