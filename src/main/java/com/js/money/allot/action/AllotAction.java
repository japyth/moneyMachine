package com.js.money.allot.action;

import com.js.money.Invest.dto.SaveInvestDto;
import com.js.money.Invest.entity.Invest;
import com.js.money.Invest.service.IInvestService;
import com.js.money.allot.dto.AllotSearchDto;
import com.js.money.allot.entity.Allot;
import com.js.money.allot.service.IAllotService;
import com.js.money.user.entity.User;
import com.js.money.user.service.IUserService;
import com.js.money.util.BaseResponse;
import com.js.money.util.SearchEntity;
import com.js.money.util.SearchResult;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/allot")
@CrossOrigin
public class AllotAction {
    @Resource
    private IUserService userService;
    @Resource
    private IAllotService allotService;
    @Resource
    private IInvestService investService;
    @RequestMapping("/saveAllot")
    public BaseResponse saveAllot(@RequestBody List<SaveInvestDto> saveInvestDtos) {
        if(!CollectionUtils.isEmpty(saveInvestDtos)) {
            List<Invest> investList = new ArrayList<>();
            for (SaveInvestDto saveInvestDto : saveInvestDtos) {
                User user = userService.getUserById(saveInvestDto.getUserId());
                if(!StringUtils.isEmpty(saveInvestDto.getInput())) {
                    double input = Double.valueOf(saveInvestDto.getInput());
                    investList.add(new Invest(user,input));
                }
            }
            investService.saveInvest(investList);
            allotService.saveAllot(new Allot(0,investList,0.00,false));
        }
        return new BaseResponse();
    }

    @RequestMapping("/getAllotPageInfo")
    public BaseResponse getAllotPageInfo(@RequestBody AllotSearchDto allotSearchDto) {
        SearchEntity searchEntity = new SearchEntity(allotSearchDto.getPageIndex(),allotSearchDto.getPageSize());
        SearchResult<Allot> allots = allotService.findAllotByPage(searchEntity);
        return new BaseResponse(allots);
    }
}
