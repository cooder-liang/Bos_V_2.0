package com.honor.bos.domain.base;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: honour丶梁 on 2018/1/26.
 * Email：18513333561@163.com
 * Function:[收派时间管理]
 */
@Entity
@Table(name = "t_taketime")
public class TakeTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;//收派时间的名称
    private String normalWorkTime;//平常上班时间
    private String normalDutyTime;//平常下班时间
    private String staWorkTime;//周六上班时间
    private String staDutyTime;//周六下班时间
    private String sunWorkTime;//周日上班时间
    private String sunDutyTime;//周日下班时间
    private String status;//状态
    private String company;//所属公司
    @Temporal(TemporalType.TIMESTAMP)
    private Date operateTime;//操作时间
    private String operator;//操作员
    private String operateCompany;//操作公司

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

    public String getNormalWorkTime() {
        return normalWorkTime;
    }

    public void setNormalWorkTime(String normalWorkTime) {
        this.normalWorkTime = normalWorkTime;
    }

    public String getNormalDutyTime() {
        return normalDutyTime;
    }

    public void setNormalDutyTime(String normalDutyTime) {
        this.normalDutyTime = normalDutyTime;
    }

    public String getStaWorkTime() {
        return staWorkTime;
    }

    public void setStaWorkTime(String staWorkTime) {
        this.staWorkTime = staWorkTime;
    }

    public String getStaDutyTime() {
        return staDutyTime;
    }

    public void setStaDutyTime(String staDutyTime) {
        this.staDutyTime = staDutyTime;
    }

    public String getSunWorkTime() {
        return sunWorkTime;
    }

    public void setSunWorkTime(String sunWorkTime) {
        this.sunWorkTime = sunWorkTime;
    }

    public String getSunDutyTime() {
        return sunDutyTime;
    }

    public void setSunDutyTime(String sunDutyTime) {
        this.sunDutyTime = sunDutyTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperateCompany() {
        return operateCompany;
    }

    public void setOperateCompany(String operateCompany) {
        this.operateCompany = operateCompany;
    }
}
