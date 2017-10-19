package com.hufu.entity.s;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * 追加建议
 */
@Entity
@Table(name = "hufu_advise")
public class Advise  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",length=10)
    private Integer id;
//    追加建议描述
    private String content;
//    追加人id
    private Integer uid;
//    提交时间
    private Date data;
//    策略id
    private Integer sid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
