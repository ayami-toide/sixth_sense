package com.example.sixth_sense.service;


import com.example.sixth_sense.domain.WordList;
import com.example.sixth_sense.repository.WordListRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WordListService {


        @Autowired
        private WordListRepository WordListRepository;

        public List<WordList> findAll(){
            return WordListRepository.findAll();
        }

        public WordList findOne(Long id){
            return WordListRepository.findById(id).get();
        }
        public WordList save(WordList wordlist){
            return WordListRepository.save(wordlist);
        }
        public void delete(Long id){
            WordListRepository.deleteById(id);
        }

}
