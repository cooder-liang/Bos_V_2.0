package com.honor.bos.dao.base;

import com.honor.bos.domain.base.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author: honour丶梁 on 2018/1/31.
 * Email：18513333561@163.com
 * Function:[]
 */
public interface CourierRepository extends JpaRepository<Courier, Integer>, JpaSpecificationExecutor<Courier> {

    @Query("update Courier set delTag='1' where id = ? ")
    @Modifying
    void updateDelTag(Integer id);

    @Query("update  Courier c set delTag=null where c.id= ? ")
    @Modifying
    void restoreDelTag(Integer id);
}
