package com.honor.bos.web.action;

import com.honor.bos.domain.base.Area;
import com.honor.bos.domain.base.Courier;
import com.honor.bos.service.base.AreaService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: honour丶梁 on 2018/2/2.
 * Email：18513333561@163.com
 * Function:[]
 */
@Controller
@Namespace("/")
@ParentPackage("json-default")
@Scope("prototype")
public class AreaAction extends ActionSupport implements ModelDriven<Area> {

    private Area area = new Area();

    @Autowired
    private AreaService areaService;

    @Override
    public Area getModel() {
        return area;
    }

    @Action(value = "area_save", results = {@Result(name = "success", location = "./pages/base/area.html", type = "redirect")})
    public String save() {
        areaService.save(area);
        return SUCCESS;
    }

    private int rows;
    private int page;

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Action(value = "area_queryPage",results = {@Result(name = "success",type = "json")})
    public String queryPage() {
        Pageable pageable=new PageRequest(page-1,rows);

        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();

                return criteriaBuilder.and(list.toArray(new Predicate[0]));
            }
        };

        Page<Courier> couriers = areaService.queryPage(specification, pageable);
        Map<String, Object> params = new HashMap<>(0);
        params.put("total", couriers.getTotalElements());
        params.put("rows", couriers.getContent());

        ActionContext.getContext().getValueStack().push(params);
        return SUCCESS;
    }


}
