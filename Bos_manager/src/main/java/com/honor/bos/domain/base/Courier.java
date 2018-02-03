package com.honor.bos.domain.base;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: honour丶梁 on 2018/1/26.
 * Email：18513333561@163.com
 * Function:[快递员]
 */
@Entity
@Table(name = "t_courier")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String courierNum;//快递员工号
    private String courierName;//快递员姓名
    private String courierPhone;//快递员手机号
    private String pda;//PDA号
    private Character delTag;//作废标志 1、已作废
    private String checkPwd;//查台密码
    private String type;//取件员类型
    private String company;//单位
    private String vechicleType;//车辆类型
    private String vechicleNum;//车牌号

    @ManyToOne
    @JoinColumn(name = "standard_id")
    private Standard standard;//取派标准

    @ManyToOne
    @JoinColumn(name = "takeTime_id")
    private TakeTime takeTime;//时间安排

    @ManyToMany(mappedBy = "couriers")
    private Set<FixArea> fixAreas = new HashSet<>();//定区

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourierNum() {
        return courierNum;
    }

    public void setCourierNum(String courierNum) {
        this.courierNum = courierNum;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public String getCourierPhone() {
        return courierPhone;
    }

    public void setCourierPhone(String courierPhone) {
        this.courierPhone = courierPhone;
    }

    public String getPda() {
        return pda;
    }

    public void setPda(String pda) {
        this.pda = pda;
    }

    public Character getDelTag() {
        return delTag;
    }

    public void setDelTag(Character delTag) {
        this.delTag = delTag;
    }

    public String getCheckPwd() {
        return checkPwd;
    }

    public void setCheckPwd(String checkPwd) {
        this.checkPwd = checkPwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVechicleType() {
        return vechicleType;
    }

    public void setVechicleType(String vechicleType) {
        this.vechicleType = vechicleType;
    }

    public String getVechicleNum() {
        return vechicleNum;
    }

    public void setVechicleNum(String vechicleNum) {
        this.vechicleNum = vechicleNum;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public TakeTime getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(TakeTime takeTime) {
        this.takeTime = takeTime;
    }

    @JSON(serialize = false)
    public Set<FixArea> getFixAreas() {
        return fixAreas;
    }

    public void setFixAreas(Set<FixArea> fixAreas) {
        this.fixAreas = fixAreas;
    }
}
