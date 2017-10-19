package com.hufu.entity.r;

import com.hufu.entity.s.Strategy;
import com.hufu.entity.u.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 录音实体
 */
@Entity
@Table(name = "hufu_record")
public class Record implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="id",length=10)
    private Integer id;
    //  录音地址
    private String url;
    //  咨询师名称
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "uid", nullable = false)
    private User user;

    //  质检员
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "suid")
    private User suser;

    //  录音评价 0、无 1、优秀 2、良好 3、一般 4、差 5、极差
    private Integer standard;
    //    0、没有被抽查 1、已被抽查到
    private Integer status;

    //    咨询项目：1、自考；2、教资。。。
    @Column(name = "item")
    private Integer item;
    //    录音日期
    private Date date;
//       录音类型 0、无 1、探需到位 2、流程完整 3、推专业灵活 4、
//       private Integer recType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;
//    private Integer tag_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "strategy_id")
    private Strategy strategy;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "stu_info_id", nullable = false)
    private StudentInfo studentInfo;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_record_tag",joinColumns = @JoinColumn(name = "record_id",referencedColumnName ="id"),inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Collection<Tag> tags=new ArrayList<Tag>();

//    录音性质：0、首咨 1、7天内 2、库存跨期
    private Integer recType;
//    录音时常
    @Column(name = "time_length")
    private Integer timeLength;
//    质检时间
    @Column(name = "test_date")
    private Date testDate;
//    订单编号
    @Column(name = "order_id")
    private String orderId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "strategy_check_info_id")
    private StrategyCheckInfo strategyCheckInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "violation_info_id")
    private ViolationInfo violationInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getSuser() {
        return suser;
    }

    public void setSuser(User suser) {
        this.suser = suser;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public Integer getRecType() {
        return recType;
    }

    public void setRecType(Integer recType) {
        this.recType = recType;
    }

    public Integer getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public StrategyCheckInfo getStrategyCheckInfo() {
        return strategyCheckInfo;
    }

    public void setStrategyCheckInfo(StrategyCheckInfo strategyCheckInfo) {
        this.strategyCheckInfo = strategyCheckInfo;
    }

    public ViolationInfo getViolationInfo() {
        return violationInfo;
    }

    public void setViolationInfo(ViolationInfo violationInfo) {
        this.violationInfo = violationInfo;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
    }
}
