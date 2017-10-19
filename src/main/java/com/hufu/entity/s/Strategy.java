package com.hufu.entity.s;

import com.hufu.entity.r.Record;
import com.hufu.entity.r.StrategyCheckInfo;
import com.hufu.entity.u.User;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
/**
 *策略实体
 */
@Entity
@Table(name = "hufu_strategy")
public class Strategy  implements Serializable {

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "strategy_id")
    private Collection<Record> records=new ArrayList<Record>();


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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_applydepart",joinColumns = @JoinColumn(name = "strategy_id"),inverseJoinColumns = @JoinColumn(name = "apply_dept_id"))
    private Collection<Department> applydeparts=new ArrayList<Department>();

    //    适用地域：1、一线城市（北上广深武）2、全国APP 3、全国SEM 4、二三线城市（外地）
    @Column(name = "region")
    public Integer region;


    //首咨
    @Column(name = "first_id")
    private Integer firstId;
    //    首咨探需    待议
    @Column(name = "first_ask_need")
    private String firstAskNeed;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_need",joinColumns = {@JoinColumn(name = "strategy_id",referencedColumnName ="id"),@JoinColumn(name ="c_id", referencedColumnName ="first_id") },inverseJoinColumns = @JoinColumn(name = "need_id"))
    private Collection<Need> needs=new ArrayList<Need>();



    //    首咨主推专业
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_major",joinColumns = @JoinColumn(name = "strategy_id"),inverseJoinColumns = @JoinColumn(name = "major_id"))
    private Collection<Major> firstMainMajors=new ArrayList<Major>();

    //    首咨主推院校
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_college",joinColumns = @JoinColumn(name = "strategy_id"),inverseJoinColumns = @JoinColumn(name = "college_id"))
    private Collection<College>  firstMainColleges=new ArrayList<College>();

    //    首咨主推项目
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_project",joinColumns = @JoinColumn(name = "strategy_id"),inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Collection<Project>  firstMainProjects=new ArrayList<Project>();

    //    首咨主推班型
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_classsize",joinColumns = {@JoinColumn(name = "strategy_id",referencedColumnName ="id"),@JoinColumn(name ="c_id", referencedColumnName ="first_id") },inverseJoinColumns = @JoinColumn(name = "classsize_id"))
    private Collection<ClassSize>  firstMainClassSizes=new ArrayList<ClassSize>();

    //    首咨截杀策略
    @Column(name = "first_sale_kill")
    private String firstSaleKill;

    //    首咨促销活动
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_promotion",joinColumns ={@JoinColumn(name ="strategy_id", referencedColumnName ="id"),@JoinColumn(name ="p_id", referencedColumnName ="first_id") },inverseJoinColumns = @JoinColumn(name = "promotion_id"))
    private Collection<Promotion> firstPromotions=new ArrayList<Promotion>();

    //    内部PK活动+激励活动
    @Column(name = "pk")
    private String PK;




    //    7天内拨打策略
    @Column(name = "sec_id")
    private Integer secId;

    //    7天内唤醒回忆，深入探需
    @Column(name = "sec_ask_need")
    private String secAskNeed;

    //    解决首咨遗留问题
    @Column(name = "slove_first_problem")
    private String solveFirstProbelm;

    //    7天内主推班型
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_classsize",joinColumns = {@JoinColumn(name = "strategy_id",referencedColumnName ="id"),@JoinColumn(name ="c_id", referencedColumnName ="sec_id") },inverseJoinColumns = @JoinColumn(name = "classsize_id"))
    private Collection<ClassSize>  secMainClassSizes=new ArrayList<ClassSize>();

    //    7天内截杀策略
    @Column(name = "sec_sale_kill")
    private String secSaleKill;

    //    7天内促销活动
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_promotion",joinColumns ={@JoinColumn(name ="strategy_id", referencedColumnName ="id"),@JoinColumn(name ="p_id", referencedColumnName ="sec_id") },inverseJoinColumns = @JoinColumn(name = "promotion_id"))
    private Collection<Promotion> secPromotions=new ArrayList<Promotion>();




    //    库存跨期
    @Column(name = "final_id")
    private Integer finalId;
    //    库存跨期触发式开场
    @Column(name = "trigger_open")
    private String triggerOpen;

    //    库存跨期辅助咨询工具
    @Column(name = "assist_tool")
    private String assistTool;

    //    库存跨期主推班型
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_strategy_classsize",joinColumns = {@JoinColumn(name = "strategy_id",referencedColumnName ="id"),@JoinColumn(name ="c_id", referencedColumnName ="final_id") },inverseJoinColumns = @JoinColumn(name = "classsize_id"))
    private Collection<ClassSize>  finalMainClassSizes=new ArrayList<ClassSize>();

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

    public Collection<Department> getApplydeparts() {
        return applydeparts;
    }

    public void setApplydeparts(Collection<Department> applydeparts) {
        this.applydeparts = applydeparts;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Integer getFirstId() {
        return firstId;
    }

    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }

    public String getFirstAskNeed() {
        return firstAskNeed;
    }

    public void setFirstAskNeed(String firstAskNeed) {
        this.firstAskNeed = firstAskNeed;
    }

    public Collection<Major> getFirstMainMajors() {
        return firstMainMajors;
    }

    public void setFirstMainMajors(Collection<Major> firstMainMajors) {
        this.firstMainMajors = firstMainMajors;
    }

    public Collection<College> getFirstMainColleges() {
        return firstMainColleges;
    }

    public void setFirstMainColleges(Collection<College> firstMainColleges) {
        this.firstMainColleges = firstMainColleges;
    }

    public Collection<Project> getFirstMainProjects() {
        return firstMainProjects;
    }

    public void setFirstMainProjects(Collection<Project> firstMainProjects) {
        this.firstMainProjects = firstMainProjects;
    }

    public Collection<ClassSize> getFirstMainClassSizes() {
        return firstMainClassSizes;
    }

    public void setFirstMainClassSizes(Collection<ClassSize> firstMainClassSizes) {
        this.firstMainClassSizes = firstMainClassSizes;
    }

    public String getFirstSaleKill() {
        return firstSaleKill;
    }

    public void setFirstSaleKill(String firstSaleKill) {
        this.firstSaleKill = firstSaleKill;
    }

    public Collection<Promotion> getFirstPromotions() {
        return firstPromotions;
    }

    public void setFirstPromotions(Collection<Promotion> firstPromotions) {
        this.firstPromotions = firstPromotions;
    }

    public String getPK() {
        return PK;
    }

    public void setPK(String PK) {
        this.PK = PK;
    }

    public Integer getSecId() {
        return secId;
    }

    public void setSecId(Integer secId) {
        this.secId = secId;
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

    public Collection<ClassSize> getSecMainClassSizes() {
        return secMainClassSizes;
    }

    public void setSecMainClassSizes(Collection<ClassSize> secMainClassSizes) {
        this.secMainClassSizes = secMainClassSizes;
    }

    public String getSecSaleKill() {
        return secSaleKill;
    }

    public void setSecSaleKill(String secSaleKill) {
        this.secSaleKill = secSaleKill;
    }

    public Collection<Promotion> getSecPromotions() {
        return secPromotions;
    }

    public void setSecPromotions(Collection<Promotion> secPromotions) {
        this.secPromotions = secPromotions;
    }

    public Integer getFinalId() {
        return finalId;
    }

    public void setFinalId(Integer finalId) {
        this.finalId = finalId;
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

    public void setFinalMainClassSizes(Collection<ClassSize> finalMainClassSizes) {
        this.finalMainClassSizes = finalMainClassSizes;
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

    public Collection<Record> getRecords() {
        return records;
    }

    public void setRecords(Collection<Record> records) {
        this.records = records;
    }

    public Collection<Need> getNeeds() {
        return needs;
    }

    public void setNeeds(Collection<Need> needs) {
        this.needs = needs;
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
