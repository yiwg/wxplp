package com.yiwg.plp.model;

import javax.persistence.*;

/*
*@date:2016/12/11
*@className:Bottel
*@author：yiweiguo
*@description:瓶子实体
*/
@Entity
@Table(name="BOTTEL")
public class Bottel {
    private Integer id;
    private User from;//来自
    private User to;//接受者
    private String content;//内容
    private int weight;//权重

    @Id
    @Column(name = "ID",nullable=false,length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = User.class, fetch=FetchType.LAZY)
    @JoinColumn(name="FROM_ID", updatable=true, nullable=false)
    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = User.class, fetch=FetchType.LAZY)
    @JoinColumn(name="TO_ID", updatable=true, nullable=true)
    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    @Column(name = "CONTENT",nullable = false ,length = 256)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "weight",nullable = true ,length = 36)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Bottel{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", content='" + content + '\'' +
                ", weight=" + weight +
                '}';
    }
}
