package com.css.dtx.notifydemo.bank1.service.impl;

import com.css.dtx.notifydemo.bank1.mapper.AccountInfoMapper;
import com.css.dtx.notifydemo.bank1.entity.AccountPay;
import com.css.dtx.notifydemo.bank1.model.AccountChangeEvent;
import com.css.dtx.notifydemo.bank1.service.AccountInfoService;
import com.css.dtx.notifydemo.bank1.spring.PayClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
@Slf4j
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    AccountInfoMapper accountInfoMapper;

    @Resource
    PayClient payClient;

    //更新账户金额
    @Override
    @Transactional
    public void updateAccountBalance(AccountChangeEvent accountChange) {
        //幂等校验
        if (accountInfoMapper.isExistTx(accountChange.getTxNo()) > 0) {
            return;
        }
        int i = accountInfoMapper.updateAccountBalance(accountChange.getAccountNo(), accountChange.getAmount());
        //插入事务记录，用于幂等控制
        accountInfoMapper.addTx(accountChange.getTxNo());
    }

    //远程调用查询充值结果
    @Override
    public AccountPay queryPayResult(String tx_no) {

        //远程调用
        AccountPay payresult = payClient.payresult(tx_no);
        if ("success".equals(payresult.getResult())) {
            //更新账户金额
            AccountChangeEvent accountChangeEvent = new AccountChangeEvent();
            accountChangeEvent.setAccountNo(payresult.getAccountNo());//账号
            accountChangeEvent.setAmount(payresult.getPayAmount());//金额
            accountChangeEvent.setTxNo(payresult.getId());//充值事务号
            updateAccountBalance(accountChangeEvent);
        }
        return payresult;
    }
}
