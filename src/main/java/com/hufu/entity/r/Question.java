package com.hufu.entity.r;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 问题
 */
@Entity
@Table(name = "hufu_question")
public class Question implements Serializable{

    public Question() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="id",length=10)
    private Integer id;
    //问题类型名
    private String name;

    //问题描述
    private String description;

    //问题类型级别
    private Integer level;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "qid")
    Collection<Question> questions=new ArrayList<Question>();

    //所属问题类型
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qid")
    private Question qid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Question getQid() {
        return qid;
    }

    public void setQid(Question qid) {
        this.qid = qid;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question){
        this.questions.add(question);
    };
}
