package com.honor.bos.domain.base;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: honour丶梁 on 2018/1/26.
 * Email：18513333561@163.com
 * Function:[定区]
 */
@Entity
@Table(name = "t_fixArea")
public class FixArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fixAreaName;//定区名称
    private String fixAreaLeader;//定区负责人
    private String phone;//联系电话
    private String company;//所属单位
    private String operateTime;//操作时间
    private String operator;//操作员
    private String operateCompany;//操作的单位

    @OneToMany(mappedBy = "fixArea")
    private Set<SubArea> subAreas=new HashSet<>();//分区

    @ManyToMany
    @JoinTable(name = "t_fixArea_couries",joinColumns = {@JoinColumn(name = "fixArea_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "couries_id",referencedColumnName = "id")})
    private Set<Courier> couriers=new HashSet<>();//取派员

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFixAreaName() {
        return fixAreaName;
    }

    public void setFixAreaName(String fixAreaName) {
        this.fixAreaName = fixAreaName;
    }

    public String getFixAreaLeader() {
        return fixAreaLeader;
    }

    public void setFixAreaLeader(String fixAreaLeader) {
        this.fixAreaLeader = fixAreaLeader;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
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

    public Set<SubArea> getSubAreas() {
        return subAreas;
    }

    public void setSubAreas(Set<SubArea> subAreas) {
        this.subAreas = subAreas;
    }

    public Set<Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(Set<Courier> couriers) {
        this.couriers = couriers;
    }
}
