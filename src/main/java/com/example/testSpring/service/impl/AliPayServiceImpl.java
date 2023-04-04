package com.example.testSpring.service.impl;

import com.alipay.api.*;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.example.testSpring.Utils.AliPayClientFactory;
import com.example.testSpring.Utils.JSONUtils;
import com.example.testSpring.entity.Orders;
import com.example.testSpring.service.AliPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class AliPayServiceImpl implements AliPayService {

  @Autowired
  private AlipayClient alipayClient;

  @Override
  public String batchPay(Orders orders) {
    try {
      BatchAlipayRequest batchAlipayRequest = new BatchAlipayRequest();
      AlipayTradePagePayModel alipayTradePrecreateModel = new AlipayTradePagePayModel();
      String tradeNo = UUID.randomUUID().toString().replaceAll("-", "");
      alipayTradePrecreateModel.setOutTradeNo(tradeNo);
      alipayTradePrecreateModel.setTotalAmount(orders.getAmount());
      alipayTradePrecreateModel.setSubject(orders.getGoods());
      batchAlipayRequest.setBizModel(alipayTradePrecreateModel);
      BatchAlipayResponse execute = alipayClient.execute(batchAlipayRequest);
      List<AlipayResponse> responseList = execute.getResponseList();
      return JSONUtils.toJsonString(responseList);
    } catch (AlipayApiException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public String pay(Orders orders) {
    try {
      AlipayTradePrecreateRequest alipayTradePrecreateRequest = new AlipayTradePrecreateRequest();
      AlipayTradePrecreateModel alipayTradePrecreateModel = new AlipayTradePrecreateModel();
      String tradeNo = UUID.randomUUID().toString().replaceAll("-", "");
      alipayTradePrecreateModel.setOutTradeNo(tradeNo);
      alipayTradePrecreateModel.setTotalAmount(orders.getAmount());
      alipayTradePrecreateModel.setSubject(orders.getGoods());
      alipayTradePrecreateRequest.setBizModel(alipayTradePrecreateModel);
      AlipayTradePrecreateResponse execute = alipayClient.execute(alipayTradePrecreateRequest);
      if (execute.isSuccess()) {
        return execute.getBody();
      } else {
        log.info(execute.getMsg());
        return execute.getMsg();
      }
    } catch (AlipayApiException e) {
      e.printStackTrace();
    }
    return null;
  }

  public String payFrom(Orders orders) {
    try {
      AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
      AlipayTradePagePayModel alipayTradePagePayModel = new AlipayTradePagePayModel();
      String tradeNo = UUID.randomUUID().toString().replaceAll("-", "");

      alipayTradePagePayModel.setGoodsType("1");
      alipayTradePagePayModel.setOutTradeNo(tradeNo);
      alipayTradePagePayModel.setTotalAmount(orders.getAmount());
      alipayTradePagePayModel.setSubject(orders.getGoods());
      alipayTradePagePayModel.setProductCode("FAST_INSTANT_TRADE_PAY");
      alipayTradePagePayRequest.setBizModel(alipayTradePagePayModel);
      AlipayTradePagePayResponse execute = alipayClient.pageExecute(alipayTradePagePayRequest);
      if (execute.isSuccess()) {
        return execute.getBody();
      } else {
        log.info(execute.getMsg());
        return execute.getMsg();
      }
    } catch (AlipayApiException e) {
      e.printStackTrace();
    }
    return null;
  }
}
