package com.honor.bos.web.action;

import com.honor.bos.domain.base.Courier;
import com.honor.bos.domain.base.Standard;
import com.honor.bos.service.base.CourierService;
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
 * @author: honour丶梁 on 2018/1/31.
 * Email：18513333561@163.com
 * Function:[]
 */
@Controller
@ParentPackage("json-default")
@Namespace("/")
@Scope("prototype")
public class CourierAction extends ActionSupport implements ModelDriven<Courier> {

    private Courier courier = new Courier();

    @Autowired
    private CourierService courierService;

    @Override
    public Courier getModel() {
        return courier;
    }

    @Action(value = "courier_save", results = {@Result(name = "success", location = "./pages/base/courier.html", type = "redirect")})
    public String save() {
        courierService.save(courier);
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

    /**
     * 查询所有
     *
     * @return
     */
    @Action(value = "courier_pageQuery", results = {@Result(name = "success", type = "json")})
    public String pageQuery() {
        Pageable pageable = new PageRequest(page - 1, rows);

        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(StringUtils.isNotBlank(courier.getCourierNum())){
                    Predicate courierNum = criteriaBuilder.equal(root.get("courierNum"), courier.getCourierNum());
                    list.add(courierNum);
                }
                if(StringUtils.isNotBlank(courier.getCompany())){
                    Predicate courierNum = criteriaBuilder.equal(root.get("company"), courier.getCompany());
                    list.add(courierNum);
                }
                if (StringUtils.isNotBlank(courier.getType())) {
                    Predicate courierNum = criteriaBuilder.equal(root.get("type"), courier.getType());
                    list.add(courierNum);
                }
                //多表查询
                Join join = root.join("standard", JoinType.INNER);
                if(courier.getStandard()!=null&&StringUtils.isNotBlank(courier.getStandard().getStandardName())){
                    Predicate p4 = criteriaBuilder.like(
                            join.get("standardName").as(String.class), "%"
                                    + courier.getStandard().getStandardName() + "%");
                    list.add(p4);
                }
                return criteriaBuilder.and(list.toArray(new Predicate[0]));
            }
        };

        Page<Courier> couriers = courierService.queryPage(specification, pageable);
        Map<String, Object> params = new HashMap<>(0);
        params.put("total", couriers.getTotalElements());
        params.put("rows", couriers.getContent());

        ActionContext.getContext().getValueStack().push(params);
        return SUCCESS;
    }

    private String ids;

    public void setIds(String ids) {
        this.ids = ids;
    }

    /**
     * 批量删除
     *
     * @return
     */
    @Action(value = "courier_delBatch", results = {@Result(name = "success", location = "./pages/base/courier.html", type = "redirect")})
    public String delBatch() {
        String[] split = ids.split(",");
        courierService.delBatch(split);
        return SUCCESS;
    }

    /**
     * 批量还原
     *
     * @return
     */
    @Action(value = "courier_restoreBatch", results = {@Result(name = "success", location = "./pages/base/courier.html", type = "redirect")})
    public String restoreBatch() {
        String[] split = ids.split(",");
        courierService.restoreBatch(split);
        return SUCCESS;
    }


}
