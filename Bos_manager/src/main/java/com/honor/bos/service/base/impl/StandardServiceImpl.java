package com.honor.bos.service.base.impl;

import com.honor.bos.dao.base.StandardRepository;
import com.honor.bos.domain.base.Standard;
import com.honor.bos.service.base.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: honour丶梁 on 2018/1/30.
 * Email：18513333561@163.com
 * Function:[]
 */
@Service
public class StandardServiceImpl implements StandardService {

    @Autowired
    private StandardRepository standardRepository;

    @Override
    public void save(Standard standard) {
        standardRepository.save(standard);
    }

    @Override
    public Page<Standard> queryPageData(Pageable pageable) {
        return standardRepository.findAll(pageable);
    }

    @Override
    public List<Standard> findAll() {
        return standardRepository.findAll();
    }


}
