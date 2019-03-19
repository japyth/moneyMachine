package com.js.money.allot.service;

import com.js.money.allot.entity.Allot;
import com.js.money.util.SearchEntity;
import com.js.money.util.SearchResult;
import org.springframework.data.domain.Page;

public interface IAllotService {
    void saveAllot(Allot allot);
    SearchResult<Allot> findAllotByPage(SearchEntity searchEntity);
}
