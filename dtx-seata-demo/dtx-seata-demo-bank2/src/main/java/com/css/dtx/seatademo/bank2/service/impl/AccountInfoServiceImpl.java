package com.css.dtx.seatademo.bank2.service.impl;

import com.css.dtx.seatademo.bank2.mapper.AccountInfoMapper;
import com.css.dtx.seatademo.bank2.service.AccountInfoService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
@Slf4j
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    AccountInfoMapper accountInfoMapper;

    @Transactional
    @Override
    public void updateAccountBalance(String accountNo, Double amount) {
        log.info("bank2 service begin,XID：{}", RootContext.getXID());
        //李四增加金额
        accountInfoMapper.updateAccountBalance(accountNo, amount);
        if (amount == 3) {
            //人为制造异常
            throw new RuntimeException("bank2 make exception..");
        }
    }
}
