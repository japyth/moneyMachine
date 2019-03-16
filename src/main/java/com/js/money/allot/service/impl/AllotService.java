package com.js.money.allot.service.impl;

import com.js.money.allot.dao.IAllotDao;
import com.js.money.allot.entity.Allot;
import com.js.money.allot.service.IAllotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("allotService")
public class AllotService implements IAllotService {
    @Resource
    private IAllotDao allotDao;
    public void saveAllot(Allot allot) {
        allotDao.saveAndFlush(allot);
    }
}
