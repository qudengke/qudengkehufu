package com.hufu.entity.r;

import com.hufu.entity.s.Major;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 策略审核信息
 */
@Entity
@Table(name = "hufu_strategy_check_info")
public class StrategyCheckInfo  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="id",length=10)
    private Integer id;


    //    策略执行信息
    //    地区：1、一线城市（北上广深武）2、全国APP 3、全国SEM 4、二三线城市（外地）
    @Column(name = "region",length=1)
    private Integer region;

    //    核实学历 0、是 1、否
    @Column (name="education",length=1)
    private Integer education;

    //    从事工作  0、是 1、否
    @Column (name="job",length=1)
    private Integer job;

    //    目的  0、是 1、否
    @Column (name="aim",length=1)
    private Integer aim;

    //    学习基础  0、是 1、否
    @Column (name="learn_base",length=1)
    private Integer learnBase;

    //    取证时间  0、是 1、否
    @Column (name="obtain_evidence_time",length=1)
    private Integer obtainEvidenceTime;

    //    策略专业
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id")
    private Major major;

    //    推荐专业
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_major_id")
    private Major referMajor;


    //班型
    //    不过退费班  0、是 1、否
    @Column (name="return_money_class",length=1)
    private Integer returnMoneyClass;

    //    专本连读班  0、是 1、否
    @Column (name="connection_read_class",length=1)
    private Integer connectionReadClass;

    //    名校精品班  0、是 1、否
    @Column (name="high_quality_class",length=1)
    private Integer highQualityClass;

    //    1对1私教  0、是 1、否
    @Column (name="one_to_one_class",length=1)
    private Integer oneToOneClass;

    //    名校精品班  0、是 1、否
    @Column (name="good_school_job_class",length=1)
    private Integer goodSchoolJobClass;

    //    名校精品班  0、是 1、否
    @Column (name="other_class",length=1)
    private Integer otherClassClass;

//    截杀执行情况

    //    学籍备案  0、是 1、否
    @Column (name="school_roll_kill",length=1)
    private Integer schoolRollKill;

    //    政策限制  0、是 1、否
    @Column (name="policy_kill",length=1)
    private Integer policyKill;

    //    助学名额  0、是 1、否
    @Column (name="help_study_num_kill",length=1)
    private Integer helpStudyNumKill;

    //    分期名额  0、是 1、否
    @Column (name="installment_num_kill",length=1)
    private Integer installmentNumKill;

    //    其他截杀  0、是 1、否
    @Column (name="other_kill",length=1)
    private Integer otherKill;

    //    流程完整性 2,4,6,8，10
    @Column (name="flow_score",length=2)
    private Integer flowScore;

    //    备注
    private String remark;

    //    是否认可  0、是 1、否
    @Column (name="accept",length=1)
    private Integer accept;

    //  结果分类
    @Column(name = "result_classify")
    private Integer resultClassify;

    //    补充说明
    private String instruction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public Integer getAim() {
        return aim;
    }

    public void setAim(Integer aim) {
        this.aim = aim;
    }

    public Integer getLearnBase() {
        return learnBase;
    }

    public void setLearnBase(Integer learnBase) {
        this.learnBase = learnBase;
    }

    public Integer getObtainEvidenceTime() {
        return obtainEvidenceTime;
    }

    public void setObtainEvidenceTime(Integer obtainEvidenceTime) {
        this.obtainEvidenceTime = obtainEvidenceTime;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Major getReferMajor() {
        return referMajor;
    }

    public void setReferMajor(Major referMajor) {
        this.referMajor = referMajor;
    }

    public Integer getReturnMoneyClass() {
        return returnMoneyClass;
    }

    public void setReturnMoneyClass(Integer returnMoneyClass) {
        this.returnMoneyClass = returnMoneyClass;
    }

    public Integer getConnectionReadClass() {
        return connectionReadClass;
    }

    public void setConnectionReadClass(Integer connectionReadClass) {
        this.connectionReadClass = connectionReadClass;
    }

    public Integer getHighQualityClass() {
        return highQualityClass;
    }

    public void setHighQualityClass(Integer highQualityClass) {
        this.highQualityClass = highQualityClass;
    }

    public Integer getOneToOneClass() {
        return oneToOneClass;
    }

    public void setOneToOneClass(Integer oneToOneClass) {
        this.oneToOneClass = oneToOneClass;
    }

    public Integer getGoodSchoolJobClass() {
        return goodSchoolJobClass;
    }

    public void setGoodSchoolJobClass(Integer goodSchoolJobClass) {
        this.goodSchoolJobClass = goodSchoolJobClass;
    }

    public Integer getOtherClassClass() {
        return otherClassClass;
    }

    public void setOtherClassClass(Integer otherClassClass) {
        this.otherClassClass = otherClassClass;
    }

    public Integer getSchoolRollKill() {
        return schoolRollKill;
    }

    public void setSchoolRollKill(Integer schoolRollKill) {
        this.schoolRollKill = schoolRollKill;
    }

    public Integer getPolicyKill() {
        return policyKill;
    }

    public void setPolicyKill(Integer policyKill) {
        this.policyKill = policyKill;
    }

    public Integer getHelpStudyNumKill() {
        return helpStudyNumKill;
    }

    public void setHelpStudyNumKill(Integer helpStudyNumKill) {
        this.helpStudyNumKill = helpStudyNumKill;
    }

    public Integer getInstallmentNumKill() {
        return installmentNumKill;
    }

    public void setInstallmentNumKill(Integer installmentNumKill) {
        this.installmentNumKill = installmentNumKill;
    }

    public Integer getOtherKill() {
        return otherKill;
    }

    public void setOtherKill(Integer otherKill) {
        this.otherKill = otherKill;
    }

    public Integer getFlowScore() {
        return flowScore;
    }

    public void setFlowScore(Integer flowScore) {
        this.flowScore = flowScore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAccept() {
        return accept;
    }

    public void setAccept(Integer accept) {
        this.accept = accept;
    }

    public Integer getResultClassify() {
        return resultClassify;
    }

    public void setResultClassify(Integer resultClassify) {
        this.resultClassify = resultClassify;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
