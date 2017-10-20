package com.hufu.entity.s;

import com.hufu.entity.r.Record;
import com.hufu.entity.r.StrategyCheckInfo;
import com.hufu.entity.u.User;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.*;

/**
 *策略实体
 */
@Entity
@Table(name = "hufu_strategy")
public class Strategy  implements Serializable {

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "strategy_id")
    private Set<Record> records=new HashSet<Record>();


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="id",length=10,nullable = false)
    private Integer id;

    //    创建者的id
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "uid")
    private User user;
    //    策略审核状态
    //  0、新建 1、下发 2、事业部负责人审核通过 3、事业部负责人审核未通过 4、sop审核通过 5、sop审核未通过
    @Column(name = "status")
    private Integer status;

    //    创建时间
    @Column(name = "create_date")
    private Date createDate;

    //    提交审核时间
    @Column(name = "submit_date")
    private Date submitDate;

    //    策略名称
    @Column(name = "name")
    private String name;

    //    策略地区
    @Column(name = "area")
    private String area;

    //    项目：1、自考；2、教资
    @Column(name = "item")
    private Integer item;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_applydepart",joinColumns = @JoinColumn(name = "strategy_id"),inverseJoinColumns = @JoinColumn(name = "apply_dept_id"))
    private Set<Department> applydeparts=new HashSet<Department>();

    //    适用地域：1、一线城市（北上广深武）2、全国APP 3、全国SEM 4、二三线城市（外地）
    @Column(name = "region")
    public Integer region;


    //首咨
    //    首咨探需    待议
    @Column(name = "first_ask_need")
    private String firstAskNeed;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_need",joinColumns =@JoinColumn(name = "strategy_id",referencedColumnName ="id"),inverseJoinColumns = @JoinColumn(name = "need_id"))
    private Set<Need> needs=new HashSet<>();



    //    首咨主推专业
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_major",joinColumns = @JoinColumn(name = "strategy_id"),inverseJoinColumns = @JoinColumn(name = "major_id"))
    private Set<Major> firstMainMajors=new HashSet<Major>();

    //    首咨主推院校
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_college",joinColumns = @JoinColumn(name = "strategy_id"),inverseJoinColumns = @JoinColumn(name = "college_id"))
    private Set<College>  firstMainColleges=new HashSet<College>();

    //    首咨主推项目
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_project",joinColumns = @JoinColumn(name = "strategy_id"),inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project>  firstMainProjects=new HashSet<Project>();

    //    首咨主推班型
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_classsize_first",joinColumns = @JoinColumn(name = "strategy_id",referencedColumnName ="id"),inverseJoinColumns = @JoinColumn(name = "classsize_id"))
    private Set<ClassSize>  firstMainClassSizes=new HashSet<ClassSize>();

    //    首咨截杀策略
    @Column(name = "first_sale_kill")
    private String firstSaleKill;

    //    首咨促销活动
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_promotion_first",joinColumns =@JoinColumn(name ="strategy_id", referencedColumnName ="id"),inverseJoinColumns = @JoinColumn(name = "promotion_id"))
    private Set<Promotion> firstPromotions=new HashSet<Promotion>();

    //    内部PK活动+激励活动
    @Column(name = "pk")
    private String PK;




    //    7天内拨打策略
    //    7天内唤醒回忆，深入探需
    @Column(name = "sec_ask_need")
    private String secAskNeed;

    //    解决首咨遗留问题
    @Column(name = "slove_first_problem")
    private String solveFirstProbelm;

    //    7天内主推班型
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_classsize_sec",joinColumns = @JoinColumn(name = "strategy_id",referencedColumnName ="id"),inverseJoinColumns = @JoinColumn(name = "classsize_id"))
    private Set<ClassSize>  secMainClassSizes=new HashSet<ClassSize>();

    //    7天内截杀策略
    @Column(name = "sec_sale_kill")
    private String secSaleKill;

    //    7天内促销活动
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_promotion_sec",joinColumns =@JoinColumn(name ="strategy_id", referencedColumnName ="id"),inverseJoinColumns = @JoinColumn(name = "promotion_id"))
    private Set<Promotion> secPromotions=new HashSet<Promotion>();




    //    库存跨期
    //    库存跨期触发式开场
    @Column(name = "trigger_open")
    private String triggerOpen;

    //    库存跨期辅助咨询工具
    @Column(name = "assist_tool")
    private String assistTool;

    //    库存跨期主推班型
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_classsize_final",joinColumns = @JoinColumn(name = "strategy_id",referencedColumnName ="id"),inverseJoinColumns = @JoinColumn(name = "classsize_id"))
    private Set<ClassSize>  finalMainClassSizes=new HashSet<ClassSize>();

    //    库存跨期终极截杀
    @Column(name = "final_sale_kill")
    private String finalSaleKill;

    //    库存跨期优惠折扣
    @Column(name = "discount")
    private String discount;


    //    竞争对手
    @Column(name = "competitor")
    private String competitor;

    //    竞争内容
    @Column(name = "compare_content")
    private String compareContent;

    //    竞争对手价格
    @Column(name = "compare_price")
    private String comparePrice;

    //    竞争对手截杀
    @Column(name = "compare_kill")
    private String compareKill;

    //    竞争分析
    @Column(name = "analyze_advantage")
    private String analyzeAdvantage;


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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }



    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }


    public String getFirstAskNeed() {
        return firstAskNeed;
    }

    public void setFirstAskNeed(String firstAskNeed) {
        this.firstAskNeed = firstAskNeed;
    }


    public Set<Department> getApplydeparts() {
        return applydeparts;
    }

    public void setApplydeparts(Set<Department> applydeparts) {
        this.applydeparts = applydeparts;
    }

    public Set<Need> getNeeds() {
        return needs;
    }

    public void setNeeds(Set<Need> needs) {
        this.needs = needs;
    }

    public Set<Major> getFirstMainMajors() {
        return firstMainMajors;
    }

    public void setFirstMainMajors(Set<Major> firstMainMajors) {
        this.firstMainMajors = firstMainMajors;
    }

    public Set<College> getFirstMainColleges() {
        return firstMainColleges;
    }

    public void setFirstMainColleges(Set<College> firstMainColleges) {
        this.firstMainColleges = firstMainColleges;
    }

    public Set<Project> getFirstMainProjects() {
        return firstMainProjects;
    }

    public void setFirstMainProjects(Set<Project> firstMainProjects) {
        this.firstMainProjects = firstMainProjects;
    }

    public Set<ClassSize> getFirstMainClassSizes() {
        return firstMainClassSizes;
    }

    public void setFirstMainClassSizes(Set<ClassSize> firstMainClassSizes) {
        this.firstMainClassSizes = firstMainClassSizes;
    }

    public Set<Promotion> getFirstPromotions() {
        return firstPromotions;
    }

    public void setFirstPromotions(Set<Promotion> firstPromotions) {
        this.firstPromotions = firstPromotions;
    }

    public Set<ClassSize> getSecMainClassSizes() {
        return secMainClassSizes;
    }

    public void setSecMainClassSizes(Set<ClassSize> secMainClassSizes) {
        this.secMainClassSizes = secMainClassSizes;
    }

    public Set<Promotion> getSecPromotions() {
        return secPromotions;
    }

    public void setSecPromotions(Set<Promotion> secPromotions) {
        this.secPromotions = secPromotions;
    }

    public void setFinalMainClassSizes(Set<ClassSize> finalMainClassSizes) {
        this.finalMainClassSizes = finalMainClassSizes;
    }

    public String getFirstSaleKill() {
        return firstSaleKill;
    }

    public void setFirstSaleKill(String firstSaleKill) {
        this.firstSaleKill = firstSaleKill;
    }


    public String getPK() {
        return PK;
    }

    public void setPK(String PK) {
        this.PK = PK;
    }



    public String getSecAskNeed() {
        return secAskNeed;
    }

    public void setSecAskNeed(String secAskNeed) {
        this.secAskNeed = secAskNeed;
    }

    public String getSolveFirstProbelm() {
        return solveFirstProbelm;
    }

    public void setSolveFirstProbelm(String solveFirstProbelm) {
        this.solveFirstProbelm = solveFirstProbelm;
    }


    public String getSecSaleKill() {
        return secSaleKill;
    }

    public void setSecSaleKill(String secSaleKill) {
        this.secSaleKill = secSaleKill;
    }


    public String getTriggerOpen() {
        return triggerOpen;
    }

    public void setTriggerOpen(String triggerOpen) {
        this.triggerOpen = triggerOpen;
    }

    public String getAssistTool() {
        return assistTool;
    }

    public void setAssistTool(String assistTool) {
        this.assistTool = assistTool;
    }

    public Collection<ClassSize> getFinalMainClassSizes() {
        return finalMainClassSizes;
    }


    public String getFinalSaleKill() {
        return finalSaleKill;
    }

    public void setFinalSaleKill(String finalSaleKill) {
        this.finalSaleKill = finalSaleKill;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getCompetitor() {
        return competitor;
    }

    public void setCompetitor(String competitor) {
        this.competitor = competitor;
    }

    public String getCompareContent() {
        return compareContent;
    }

    public void setCompareContent(String compareContent) {
        this.compareContent = compareContent;
    }

    public String getComparePrice() {
        return comparePrice;
    }

    public void setComparePrice(String comparePrice) {
        this.comparePrice = comparePrice;
    }

    public String getCompareKill() {
        return compareKill;
    }

    public void setCompareKill(String compareKill) {
        this.compareKill = compareKill;
    }

    public String getAnalyzeAdvantage() {
        return analyzeAdvantage;
    }

    public void setAnalyzeAdvantage(String analyzeAdvantage) {
        this.analyzeAdvantage = analyzeAdvantage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    public void addNeeds(Need need){
        this.needs.add(need);
    }

    public void addFirstMainMajors(Major major){
        this.firstMainMajors.add(major);
    }

    public void addFirstMainColleges(College college){
        this.firstMainColleges.add(college);
    }

    public void addFirstMainProjects(Project project){
        this.firstMainProjects.add(project);
    }

    public void addFirstMainClassSizes(ClassSize classSize){
        this.firstMainClassSizes.add(classSize);
    }

    public void addFirstPromotions(Promotion promotion){
        this.firstPromotions.add(promotion);
    }

    public void addSecMainClassSizes(ClassSize classSize){
        this.secMainClassSizes.add(classSize);
    }

    public void addSecPromotions(Promotion promotion){
        this.secPromotions.add(promotion);
    }

    public void addFinalMainClassSizes(ClassSize classSize){
        this.finalMainClassSizes.add(classSize);
    }
}
