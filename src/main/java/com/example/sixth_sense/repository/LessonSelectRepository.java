package com.example.sixth_sense.repository;


import com.example.sixth_sense.domain.LessonSelect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonSelectRepository extends JpaRepository<LessonSelect, Long> {
}
