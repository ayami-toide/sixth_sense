package com.example.sixth_sense.repository;


import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="wordlist")
public class WordList {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name="word", nullable=false)
    private String word;

    @Column(name="meaning1", nullable=false)
    private  String meaning1;

    @Column(name="meaning2", nullable=false)
    private  String meaning2;

    @Column(name="meaning3", nullable=false)
    private  String meaning3;

    @Column(name="meaning4", nullable=false)
    private  String meaning4;
}
