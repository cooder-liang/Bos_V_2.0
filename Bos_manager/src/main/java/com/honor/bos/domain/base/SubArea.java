package com.honor.bos.domain.base;

import javax.persistence.*;

/**
 * @author: honour丶梁 on 2018/1/26.
 * Email：18513333561@163.com
 * Function:[分区]
 */
@Entity
@Table(name = "t_subArea")
public class SubArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String startNum;//起始号
    private String endNum;//停止号
    private Character single;//单双号
    private String keyWords;//关键字
    private String assitKeyWords;//辅助关键字

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;//区域
    @ManyToOne
    @JoinColumn(name = "fixArea_id")
    private FixArea fixArea;//定区

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartNum() {
        return startNum;
    }

    public void setStartNum(String startNum) {
        this.startNum = startNum;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }

    public Character getSingle() {
        return single;
    }

    public void setSingle(Character single) {
        this.single = single;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getAssitKeyWords() {
        return assitKeyWords;
    }

    public void setAssitKeyWords(String assitKeyWords) {
        this.assitKeyWords = assitKeyWords;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public FixArea getFixArea() {
        return fixArea;
    }

    public void setFixArea(FixArea fixArea) {
        this.fixArea = fixArea;
    }
}
