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
        public List<WordList> findWords(){

            return wordListMapper.findWords();

        }

        @Transactional
        public WordList findTestWord(Long id){
            return wordListMapper.findTestWord(id);

        }

        @Transactional
        public WordList findTestMeaning(Long id){
        return wordListMapper.findTestMeaning(id);

    }


        @Transactional
        public List<WordList> findAll(){

            return wordListMapper.findAll();
        }

        @Transactional
        public WordList findOne(Long id){

            return wordListMapper.findOne(id);
        }

        @Transactional
        public  int findCount(){
            return wordListMapper.findCount();
        }

        @Transactional
        public  int findCountStatus(){
            return wordListMapper.findCountStatus();
        }

        @Transactional
        public  int findStudiedWord(){
            return wordListMapper.findStudiedWord();
        }

        @Transactional
        public void save(WordList wordlist){

           wordListMapper.save(wordlist);
        }

        @Transactional
        public void update(WordList wordlist){

            wordListMapper.update(wordlist);
        }

        //Geeee Rina
        @Transactional
        public void flick_status_zero(String word){

            wordListMapper.flick_status_zero(word);
        }

        //Geeee Rina
        @Transactional
        public void flick_status_ichi(String word){

            wordListMapper.flick_status_ichi(word);
        }

        @Transactional
        public void delete(Long id){

            wordListMapper.delete(id);
        }

}
