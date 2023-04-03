package com.example.testSpring.Utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.example.testSpring.config.staticData.AliPayData;

public class AliPayClientFactory {

    private AliPayClientFactory(){};

    public static DefaultAlipayClient getDefaultAlipayClient(){
        try {
            return  new DefaultAlipayClient(AliPayData.alipayConfig);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }
}
