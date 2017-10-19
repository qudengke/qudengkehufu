package com.hufu.entity.s;

import javax.persistence.*;
import java.io.Serializable;

/**
 *项目
 */
@Entity
@Table(name = "hufu_project")
public class Project  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",length=10)
    private Integer id;
//    项目名称
    private String name;
//    项目描述
    private String description;

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
}
