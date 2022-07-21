package com.css.dtx.notifydemo.pay.service;


import com.css.dtx.notifydemo.pay.entity.AccountPay;

/**
 * Created by Administrator.
 */
public interface AccountPayService {

    //充值
    public AccountPay insertAccountPay(AccountPay accountPay);
    //查询充值结果
    public AccountPay getAccountPay(String txNo);
}
