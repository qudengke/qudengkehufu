package com.hufu.entity.r;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 违规类型
 */
@Entity
@Table(name = "hufu_violation_type")
public class ViolationType implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",length=10)
    private Integer id;

//违规类型名
    private String name;

    //违规描述
    private String description;

    //违规类型级别
    private Integer level;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vid")
    Collection<ViolationType> violationTypes=new ArrayList<ViolationType>();

    //所属违规类型
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vid")
    private ViolationType vid;

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

    public ViolationType getVid() {
        return vid;
    }

    public void setVid(ViolationType vid) {
        this.vid = vid;
    }

    public Collection<ViolationType> getViolationTypes() {
        return violationTypes;
    }

    public void setViolationTypes(Collection<ViolationType> violationTypes) {
        this.violationTypes = violationTypes;
    }
}
