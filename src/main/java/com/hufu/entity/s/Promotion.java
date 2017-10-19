package com.hufu.entity.s;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *促销活动
 */
@Entity
@Table(name = "hufu_promotion")
public class Promotion  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",length=10)
    private Integer id;
    //    促销名称
    private String name;
    //    促销描述
    private String description;

    //    创建时间
    @Column(name = "create_date")
    private Date createDate;

    //    结束时间
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getOverDate() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }
}
