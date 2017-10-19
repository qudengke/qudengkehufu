package com.hufu.entity.s;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 院校实体
 */
@Entity
@Table(name = "hufu_college")
public class College  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",length=10)
    private Integer id;
//    院校名称
    private String name;
//    院校所属区域id
    private Integer area_id;

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

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

}
