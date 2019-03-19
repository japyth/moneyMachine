package com.js.money.allot.service.impl;

import com.js.money.allot.dao.IAllotDao;
import com.js.money.allot.entity.Allot;
import com.js.money.allot.service.IAllotService;
import com.js.money.util.SearchEntity;
import com.js.money.util.SearchResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("allotService")
public class AllotService implements IAllotService {
    @Resource
    private IAllotDao allotDao;
    public void saveAllot(Allot allot) {
        allotDao.saveAndFlush(allot);
    }

    @Override
    public SearchResult<Allot> findAllotByPage(SearchEntity searchEntity) {
        Sort sort = new Sort(Sort.Direction.DESC,"updateTime"); //创建时间降序排序
        Pageable pageable =  PageRequest.of(searchEntity.getPageIndex()-1,searchEntity.getPageSize(),sort);
        Page<Allot> allotPage = allotDao.findAll(pageable);
        return new SearchResult<Allot>(allotPage.getContent(),allotPage.getTotalPages(),allotPage.getTotalElements());
    }
}
