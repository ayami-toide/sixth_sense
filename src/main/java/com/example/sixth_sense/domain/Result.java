package com.example.sixth_sense.domain;

import javax.persistence.*;

    @Entity
    @Table(name = "result")
    public class Result {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @Column(name = "word_id", nullable = false)
        private Integer word_id;

        public Integer getId(){
            return id;
        }

        public Integer getWord_id() {

            return word_id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setWord_id(Integer word_id){
            this.word_id = word_id;
        }

    }
