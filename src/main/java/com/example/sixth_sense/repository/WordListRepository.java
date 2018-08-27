package com.example.sixth_sense.repository;


import com.example.sixth_sense.domain.WordList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordListRepository extends JpaRepository<WordList, Long> {
}
