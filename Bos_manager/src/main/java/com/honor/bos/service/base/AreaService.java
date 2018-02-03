package com.honor.bos.service.base;

import com.honor.bos.domain.base.Area;
import com.honor.bos.domain.base.Courier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author: honour丶梁 on 2018/2/2.
 * Email：18513333561@163.com
 * Function:[]
 */
public interface AreaService {
    void save(Area area);

    Page<Courier> queryPage(Specification specification, Pageable pageable);
}
