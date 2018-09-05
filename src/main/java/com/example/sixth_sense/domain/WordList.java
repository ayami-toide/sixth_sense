package com.example.sixth_sense.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


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
    private String meaning;

    @Column(name="hazure1", nullable = false)
    private String hazure1;

    @Column(name="hazure2", nullable = false)
    private String hazure2;

    @Column(name="hazure3", nullable = false)
    private String hazure3;

    @Column(name="flicker", nullable=false)
    private  Integer flicker;

    @Column(name="status", nullable=true)
    private  Integer status;

    @Column(name="perfect", nullable=false)
    private  Integer perfect;

    @Column(name="hatena", nullable=false)
    private  Integer hatena;

    @Column(name="url", nullable=false)
    private  String url;

    public Integer getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getHazure1() {
        return hazure1;
    }

    public String getHazure2() {
        return hazure2;
    }

    public String getHazure3() {
        return hazure3;
    }

    public Integer getFlicker() {
        return flicker;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getPerfect() {
        return perfect;
    }

    public String getUrl() {
        return url;
    }
  
    public Integer getHatena() {
        return hatena;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getShuffledAnswers() {
        ArrayList<String> answers = new ArrayList<String>();
        answers.add (getMeaning());
        answers.add(getHazure1());
        answers.add(getHazure2());
        answers.add(getHazure3());
        Collections.shuffle(answers);

        // シャッフルする
        return  answers;
    }
}