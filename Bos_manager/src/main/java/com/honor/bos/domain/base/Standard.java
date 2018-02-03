package com.honor.bos.domain.base;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: honour丶梁 on 2018/1/26.
 * Email：18513333561@163.com
 * Function:[收派标准]
 */
@Entity
@Table(name = "t_standard")
public class Standard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String standardName;//收派标准的名称
    private Integer minWeight;//最小重量
    private Integer maxWeight;//最大重量
    private Integer minLength;//最小长度
    private Integer maxLength;//最大长度
    @Temporal(TemporalType.TIMESTAMP)
    private Date operateTime;//操作时间
    private String operator;//操作员
    private String operateCompany;//操作单位

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public Integer getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Integer minWeight) {
        this.minWeight = minWeight;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
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
