package com.example.sixth_sense.domain;

import javax.persistence.*;

    @Entity
    @Table(name = "lessonselect")
    public class LessonSelect {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @Column(name = "lesson_id", nullable = false)
        private Integer lesson_id;

        @Column(name = "status", nullable = false)
        private Integer status;

        @Column(name = "maru_status", nullable = false)
        private Integer maru_status;

        public  Integer getId(){
            return id;
        }

        public Integer getLesson_id() {
            return lesson_id;
        }

        public Integer getstatus() {
            return status;
        }

        public  Integer getmaru_status(){
            return  maru_status;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setLesson_id(Integer lesson_id){
            this.lesson_id = lesson_id;
        }

        public void setStatus(Integer status){
            this.status = status;
        }

        public  void setMaru_status(Integer maru_status){ this.maru_status = maru_status; }

    }
