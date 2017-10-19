package com.hufu.entity.r;

import com.hufu.entity.u.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 违规信息
 */
@Entity
@Table(name = "hufu_violation_info")
public class ViolationInfo  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="id",length=10)
    private Integer id;

    //    是否追责  0、是 1、否
    @Column(name="find_duty",length=1)
    private Integer findDuty;

    //    违规时间
    @Column (name="bad_time")
    private String badTime;

    //    是否扣除流水  0、是 1、否
    @Column (name="water",length=1)
    private Integer water;
    //    罚款金额
    private Integer forfeit;

    //  责任人
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "uid")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_violation_type_info",joinColumns = @JoinColumn(name = "violation_info_id"),inverseJoinColumns = @JoinColumn(name = "violation_type_id"))
    Collection<ViolationType> violationTypes=new ArrayList<ViolationType>();

    //    是否可以回访申诉  0、是 1、否
    @Column (name="appeal",length=1)
    private Integer appeal;


    //    申诉是否成功  0、是 1、否
    @Column (name="success",length=1)
    private Integer success;

    //  申诉结果
    @Column(name = "result")
    private String result;

    //    补充说明
    private String instruction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFindDuty() {
        return findDuty;
    }

    public void setFindDuty(Integer findDuty) {
        this.findDuty = findDuty;
    }

    public String getBadTime() {
        return badTime;
    }

    public void setBadTime(String badTime) {
        this.badTime = badTime;
    }

    public Integer getWater() {
        return water;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    public Integer getForfeit() {
        return forfeit;
    }

    public void setForfeit(Integer forfeit) {
        this.forfeit = forfeit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<ViolationType> getViolationTypes() {
        return violationTypes;
    }

    public void setViolationTypes(Collection<ViolationType> violationTypes) {
        this.violationTypes = violationTypes;
    }

    public Integer getAppeal() {
        return appeal;
    }

    public void setAppeal(Integer appeal) {
        this.appeal = appeal;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void addViolation(ViolationType violationType){
        this.violationTypes.add(violationType);
    }
}
