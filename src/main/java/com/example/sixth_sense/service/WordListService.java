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
        private WordListMapper wordlistMapper;

        //Geeee Rina
        @Transactional
        public List<WordList> findWords(){

            return wordlistMapper.findWords();
        }

        @Transactional
        public List<WordList> findAll(){

            return wordlistMapper.findAll();
        }

        @Transactional
        public WordList findOne(Long id){

            return wordlistMapper.findOne(id);
        }

        @Transactional
        public  int findCount(){
            return wordlistMapper.findCount();
        }

        @Transactional
        public  int findCountStatus(){
            return wordlistMapper.findCountStatus();
        }

        @Transactional
        public  int findStudiedWord(){
            return wordlistMapper.findStudiedWord();
        }

        @Transactional
        public  int findCountStudyingNow(){
            return wordlistMapper.findCountStudyingNow();
        }

        @Transactional
        public  int findCountPerfect(){
            return wordlistMapper.findCountPerfect();
        }



        @Transactional
        public void save(WordList wordlist){

           wordlistMapper.save(wordlist);
        }

        @Transactional
        public void update(WordList wordlist){

            wordlistMapper.update(wordlist);
        }

        @Transactional
        public void delete(Long id){

            wordlistMapper.delete(id);
        }

}
