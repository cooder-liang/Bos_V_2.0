package com.honor.bos.service.base.impl;

import com.honor.bos.dao.base.AreaRepository;
import com.honor.bos.domain.base.Area;
import com.honor.bos.domain.base.Courier;
import com.honor.bos.service.base.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: honour丶梁 on 2018/2/2.
 * Email：18513333561@163.com
 * Function:[]
 */
@Service
@Transactional
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository repository;

    @Override
    public void save(Area area) {
        repository.save(area);
    }

    @Override
    public Page<Courier> queryPage(Specification specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }
}
