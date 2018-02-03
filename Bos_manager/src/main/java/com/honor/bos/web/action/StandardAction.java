package com.honor.bos.web.action;

import com.alibaba.fastjson.JSONObject;
import com.honor.bos.domain.base.Standard;
import com.honor.bos.service.base.StandardService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: honour丶梁 on 2018/1/30.
 * Email：18513333561@163.com
 * Function:[]
 */
@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Scope("prototype")
public class StandardAction extends ActionSupport implements ModelDriven<Standard> {

    private Standard standard = new Standard();
    @Autowired
    private StandardService standardService;

    @Override
    public Standard getModel() {
        return standard;
    }

    @Action(value = "standard_save", results = {@Result(name = "success", location = "./pages/base/standard.html", type = "redirect")})
    public String save() {
        standardService.save(standard);
        return SUCCESS;
    }

    private int page;
    private int rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Action(value = "standard_pageQuery")
    public void pageQuery() {
        try {
            Pageable pageable = new PageRequest(page - 1, rows);
            Page<Standard> standards = standardService.queryPageData(pageable);

            Map<String, Object> params = new HashMap<>(0);
            params.put("total", standards.getTotalElements());
            params.put("rows", standards.getContent());
            ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
            ServletActionContext.getResponse().getWriter().write(JSONObject.toJSONString(params));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有的收派标准
     */
    @Action("standard_findAll")
    public void findAll(){
        try {
            List<Standard> standards = standardService.findAll();
            ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
            ServletActionContext.getResponse().getWriter().write(JSONObject.toJSONString(standards));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
