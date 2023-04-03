package com.example.testSpring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Orders {

    public String alipayId;

    public String goods;

    public String amount;

    public String merchantId ;
}
