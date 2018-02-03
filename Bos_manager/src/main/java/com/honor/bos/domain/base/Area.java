package com.honor.bos.domain.base;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: honour丶梁 on 2018/1/26.
 * Email：18513333561@163.com
 * Function:[地域信息实体类，主要包含 省市区(县)]
 */
@Entity
@Table(name = "t_area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String province;//省
    private String city;//城市
    private String district;//区域
    private String postCode;//邮编
    private String cityCode;//城市编码
    private String shortCode;//简码

    @OneToMany(mappedBy = "area")
    private Set<SubArea> subAreas = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
    @JSON(serialize = false)
    public Set<SubArea> getSubAreas() {
        return subAreas;
    }

    public void setSubAreas(Set<SubArea> subAreas) {
        this.subAreas = subAreas;
    }
}
