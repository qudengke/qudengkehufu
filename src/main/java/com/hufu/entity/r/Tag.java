package com.hufu.entity.r;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 标签
 */
@Entity
@Table(name = "hufu_tag")
public class Tag  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="id",length=10)
    private Integer id;

    private String tagName;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_record_tag",joinColumns = @JoinColumn(name = "tag_id",referencedColumnName ="id"),inverseJoinColumns = @JoinColumn(name = "record_id"))
    private Collection<Record> records=new ArrayList<Record>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Collection<Record> getRecords() {
        return records;
    }

    public void setRecords(Collection<Record> records) {
        this.records = records;
    }

    public void addRecord(Record record){
        this.records.add(record);
    }
}
