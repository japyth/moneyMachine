package com.js.money.Invest.dao;

import com.js.money.Invest.entity.Invest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvestDao extends JpaRepository<Invest,String> {
}
