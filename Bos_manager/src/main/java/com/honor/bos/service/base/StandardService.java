package com.honor.bos.service.base;

import com.honor.bos.domain.base.Standard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author: honour丶梁 on 2018/1/30.
 * Email：18513333561@163.com
 * Function:[]
 */
public interface StandardService {

    /**
     * 保存收派标准
     *
     * @param standard
     */
    void save(Standard standard);

    /**
     * 查询当前分页的所有数据
     *
     * @param pageable
     * @return
     */
    Page<Standard> queryPageData(Pageable pageable);

    /**
     * 查询所有的收派标准
     * @return
     */
    List<Standard> findAll();

}
