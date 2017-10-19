package com.hufu.entity.s;

import com.hufu.entity.r.Record;
import com.hufu.entity.r.StrategyCheckInfo;
import com.hufu.entity.r.StudentInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *专业
 */
@Entity
@Table(name = "hufu_major")
public class Major  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",length=10)
    private Integer id;
//    专业名称
    private String name;
//    所属专业id
    private Integer mid;
//    专业级别
    private Integer level;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "major_id")
    Collection<StudentInfo> studentInfos=new ArrayList<StudentInfo>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "major_id")
    Collection<StrategyCheckInfo> strategyCheckInfos1=new ArrayList<StrategyCheckInfo>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_major_id")
    Collection<StrategyCheckInfo> strategyCheckInfos2=new ArrayList<StrategyCheckInfo>();

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

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}
