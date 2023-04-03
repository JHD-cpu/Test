package com.example.testSpring.Controller;


import com.example.testSpring.entity.Orders;
import com.example.testSpring.service.AliPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alipay")
@Slf4j
public class AlipayController {

    @Autowired
    private AliPayService aliPayService;

    /**
     * 下订单，返回支付页面
     * @param orders
     * @return
     */
    @PostMapping("/getPayPage")
    public String getPayPage(@RequestBody Orders orders)  {
      return aliPayService.payFrom(orders);
    }


    /**
     *  支付回调
     * @param orders
     * @return
     */
    @PostMapping("/putPayCall")
    public String putPayCall( String orders)  {
        return  "true";
    }
}
