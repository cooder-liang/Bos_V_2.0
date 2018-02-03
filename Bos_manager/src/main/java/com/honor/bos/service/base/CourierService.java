package com.honor.bos.service.base;

import com.honor.bos.domain.base.Courier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author: honour丶梁 on 2018/1/31.
 * Email：18513333561@163.com
 * Function:[]
 */
public interface CourierService {

    /**
     * 添加取派员
     *
     * @param courier
     */
    void save(Courier courier);

    /**
     * 分页查询
     *
     * @param pageable
     * @return
     */
    Page<Courier> queryPage(Specification specification,Pageable pageable);

    /**
     * 批量删除
     *
     * @param ids
     */
    void delBatch(String[] ids);

    /**
     * 批量还原
     *
     * @param split
     */
    void restoreBatch(String[] split);
}
