package com.js.money.Invest.action;

import com.js.money.Invest.dto.SaveInvestDto;
import com.js.money.Invest.entity.Invest;
import com.js.money.Invest.service.IInvestService;
import com.js.money.user.entity.User;
import com.js.money.user.service.IUserService;
import com.js.money.util.BaseResponse;
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
@RequestMapping("api/invest")
@CrossOrigin
public class InvestAction {
    @Resource
    private IUserService userService;
    @Resource
    private IInvestService investService;

}
