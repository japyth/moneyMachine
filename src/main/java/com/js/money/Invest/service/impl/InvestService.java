package com.js.money.Invest.service.impl;


import com.js.money.Invest.dao.IInvestDao;
import com.js.money.Invest.entity.Invest;
import com.js.money.Invest.service.IInvestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("investService")
public class InvestService implements IInvestService {
    @Resource
    IInvestDao investDao;
    @Override
    public void saveInvest(List<Invest> invest) {
        investDao.saveAll(invest);
    }
}
