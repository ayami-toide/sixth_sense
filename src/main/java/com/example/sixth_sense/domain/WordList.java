package com.example.sixth_sense.domain;



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

    @Column(name="meaning", nullable=false)
    private  String meaning;

    @Column(name="flicker", nullable=false)
    private  Integer flicker;

    @Column(name="hatena", nullable=false)
    private  Integer hatena;

    @Column(name="status", nullable=true)
    private  Integer status;


}
