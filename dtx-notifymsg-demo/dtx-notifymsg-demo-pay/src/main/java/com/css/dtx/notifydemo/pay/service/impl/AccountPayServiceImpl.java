package com.css.dtx.notifydemo.pay.service.impl;

import com.css.dtx.notifydemo.pay.mapper.AccountPayMapper;
import com.css.dtx.notifydemo.pay.entity.AccountPay;
import com.css.dtx.notifydemo.pay.service.AccountPayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
@Slf4j
public class AccountPayServiceImpl implements AccountPayService {

    @Autowired
    AccountPayMapper accountPayMapper;

    @Resource
    RocketMQTemplate rocketMQTemplate;

    //插入充值记录
    @Override
    public AccountPay insertAccountPay(AccountPay accountPay) {
        int success = accountPayMapper.insertAccountPay(accountPay.getId(), accountPay.getAccountNo(), accountPay.getPayAmount(), "success");
        if (success > 0) {
            //发送通知,使用普通消息发送通知
            accountPay.setResult("success");
            rocketMQTemplate.convertAndSend("topic_notifymsg", accountPay);
            return accountPay;
        }
        return null;
    }

    //查询充值记录，接收通知方调用此方法来查询充值结果
    @Override
    public AccountPay getAccountPay(String txNo) {
        AccountPay accountPay = accountPayMapper.findByIdTxNo(txNo);
        return accountPay;
    }
}
