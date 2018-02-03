package com.honor.bos.service.base.impl;

import com.honor.bos.dao.base.CourierRepository;
import com.honor.bos.domain.base.Courier;
import com.honor.bos.service.base.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: honour丶梁 on 2018/1/31.
 * Email：18513333561@163.com
 * Function:[]
 */
@Service
@Transactional
public class CourierServiceImpl implements CourierService {

    @Autowired
    private CourierRepository courierRepository;

    @Override
    public void save(Courier courier) {
        courierRepository.save(courier);
    }

    @Override
    public Page<Courier> queryPage(Specification specification, Pageable pageable) {
        return courierRepository.findAll(specification, pageable);
    }

    @Override
    public void delBatch(String[] ids) {
        //将delTag的值设置为1
        for (String id : ids) {
            int id1 = Integer.parseInt(id);
            courierRepository.updateDelTag(id1);
        }
    }

    @Override
    public void restoreBatch(String[] split) {
        for (String s : split) {
            int id = Integer.parseInt(s);
            courierRepository.restoreDelTag(id);
        }
    }
}
