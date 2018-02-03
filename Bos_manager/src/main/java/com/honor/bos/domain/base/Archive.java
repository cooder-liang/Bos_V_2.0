package com.honor.bos.domain.base;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: honour丶梁 on 2018/1/26.
 * Email：18513333561@163.com
 * Function:[档案类，记录所有的分类信息，在子档中]
 */
@Entity
@Table(name = "t_archive")
public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String archiveNum;//档案编号
    private String archiveName;//档案名称
    private String remark;//备注
    private Integer hasChild;//0表示不分级   1表示分级
    @Temporal(TemporalType.TIMESTAMP)
    private Date operateTime;//操作时间
    private String operator;//操作员
    private String operateCompany;//操作单位
    @OneToMany(mappedBy = "archive")
    private Set<SubArchive> subArchives = new HashSet<>();//子档案

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArchiveNum() {
        return archiveNum;
    }

    public void setArchiveNum(String archiveNum) {
        this.archiveNum = archiveNum;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getHasChild() {
        return hasChild;
    }

    public void setHasChild(Integer hasChild) {
        this.hasChild = hasChild;
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

    public Set<SubArchive> getSubArchives() {
        return subArchives;
    }

    public void setSubArchives(Set<SubArchive> subArchives) {
        this.subArchives = subArchives;
    }
}
