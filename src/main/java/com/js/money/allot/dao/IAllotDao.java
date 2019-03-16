package com.js.money.allot.dao;

import com.js.money.allot.entity.Allot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAllotDao extends JpaRepository<Allot,String> {
}
