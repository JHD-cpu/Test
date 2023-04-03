package com.example.testSpring.service;

import com.example.testSpring.entity.Orders;

public interface AliPayService {

    String  batchPay(Orders orders) ;
    String  pay(Orders orders) ;
    String  payFrom(Orders orders) ;

}
