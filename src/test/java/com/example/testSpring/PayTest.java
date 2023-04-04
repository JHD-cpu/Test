package com.example.testSpring;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.example.testSpring.Utils.AliPayClientFactory;
import com.example.testSpring.config.AliPayConfig;

import java.util.UUID;

public class PayTest {

  public static void main(String[] args) throws Exception {
    tradePagePay();
  }
  public static void  tradePagePay() throws AlipayApiException {
    AlipayClient alipayClient = new AliPayConfig().alipayClient(new AliPayConfig().alipayConfig());
    AlipayTradePagePayRequest alipayTradePrecreateRequest = new AlipayTradePagePayRequest();
    AlipayTradePagePayModel alipayTradePrecreateModel=new AlipayTradePagePayModel();
    String tradeNo = UUID.randomUUID().toString().replaceAll("-", "");
    System.out.println(tradeNo);
    alipayTradePrecreateModel.setOutTradeNo(tradeNo);
    alipayTradePrecreateModel.setTotalAmount("8888");
    alipayTradePrecreateModel.setSubject("Iphone 17 proMax");
    alipayTradePrecreateRequest.setBizModel(alipayTradePrecreateModel);
    AlipayTradePagePayResponse execute = alipayClient.pageExecute(alipayTradePrecreateRequest);
    System.out.println(execute.getBody());
  }
  public void  preCreate() throws AlipayApiException {
    AlipayClient alipayClient = new AliPayConfig().alipayClient(new AliPayConfig().alipayConfig());
    AlipayTradePrecreateRequest alipayTradePrecreateRequest = new AlipayTradePrecreateRequest();
    AlipayTradePrecreateModel alipayTradePrecreateModel=new AlipayTradePrecreateModel();
    String tradeNo = UUID.randomUUID().toString().replaceAll("-", "");
    System.out.println(tradeNo);
    alipayTradePrecreateModel.setOutTradeNo(tradeNo);
    alipayTradePrecreateModel.setTotalAmount("8888");
    alipayTradePrecreateModel.setSubject("Iphone 17 proMax");
    alipayTradePrecreateRequest.setBizModel(alipayTradePrecreateModel);
    AlipayTradePrecreateResponse execute = alipayClient.execute(alipayTradePrecreateRequest);
    System.out.println(execute.getBody());
  }
}
