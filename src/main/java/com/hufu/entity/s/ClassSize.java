package com.hufu.entity.s;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * 班型
 */

@Entity
@Table(name = "hufu_class_size")
public class ClassSize implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",length=10)
    private Integer id;
//    班型名称
    private String name;
//    班型描述
    private String description;
    //    班型结束时间
    @Column(name = "over_date")
    private Date overDate;
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

    public Date getOverDate() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

}
