package com.honor.bos.domain.base;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: honour丶梁 on 2018/1/26.
 * Email：18513333561@163.com
 * Function:[子档案类，记录了档案分级后的子信息]
 */
@Entity
@Table(name = "t_subArchive")
public class SubArchive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subArchiveName;//子档案名称
    private String mnemonicCode;//助记码
    private String remark;//备注
    private String mothballed;//封存标志
    @Temporal(TemporalType.TIMESTAMP)
    private Date operateTime;//操作时间
    private String operator;//操作员
    private String operateCompany;//操作单位
    @ManyToOne
    @JoinColumn(name = "archive_id")
    private Archive archive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubArchiveName() {
        return subArchiveName;
    }

    public void setSubArchiveName(String subArchiveName) {
        this.subArchiveName = subArchiveName;
    }

    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMothballed() {
        return mothballed;
    }

    public void setMothballed(String mothballed) {
        this.mothballed = mothballed;
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

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }
}
