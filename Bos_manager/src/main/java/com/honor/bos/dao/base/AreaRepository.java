package com.honor.bos.dao.base;

import com.honor.bos.domain.base.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: honour丶梁 on 2018/2/2.
 * Email：18513333561@163.com
 * Function:[]
 */
public interface AreaRepository extends JpaRepository<Area, Integer>, JpaSpecificationExecutor<Area> {
}
