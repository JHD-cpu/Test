package com.example.testSpring.config.staticData;

import com.alipay.api.AlipayConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class AliPayData {
  // 支付宝appId
  public static final String app_id_dev= "2021000117658538";

  public static final String app_id= "2021003187606104";
  // 商户账号
  public static final String merchant_account = "2088621955813217";
  // 支付宝网关
  public static final String alipay_gateway_address_dev = "https://openapi.alipaydev.com/gateway.do";

  public static final String alipay_gateway_address = "https://openapi.alipay.com/gateway.do";

  // 支付宝公钥
  public static final String alipay_public_key_dev = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjG8v/+REcRZTfmyzihboDAIJDlHzGazJ4JFCor3YZTLYqS6Ov3uVL7N9uIyMG7g1YEtIiSqrm717v9kHihc77j/ACU33yi0h/avZBvNJzWYxyaer3oS2tjFaSyYoW2c61igHyvMsZ1y5HH1GCYge+fn0uJdAfMRMAXi0I0MYQ4cOX96wYr468dT9sLq8on/R7G0AoctnpZMdbfePlm96zQqf+lJHANwiU1hAcCyDp9gckFBWvvjw5cUISB5BoPH1nS+AnyHh9Wv6xOfsKR+pzhI5pKR4qgBlExp4rEyl72OUTNe1ZPNZorDF2lx7lNQBzS/zLI6F+HI5Rqp6/sV24QIDAQAB";
  public static final String alipay_public_key= "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6Hb0HHfcj9PhUBLWrSsbcnt5CABifNy5PlghqntC3s7A+qmOH4iJHE/ktE//gH5vF17lxFbB/fFcdnKQl9D8th9XIYf8VZkkPE9pKYnYKprl9t8MsCzNOtrCQfcZwemChXFxdGeNJ2QlEwZ2iJ6jJdhLirKLiGXpqwJh+QVe3E/DkmVPlM9rSr3D3yBwM8sRnvhwJOksDRYVW5WgqFMKooYpWq8QS2sNmfbOiQyeQ7Mv2NlldpdkspAcQZ8O3VdTDVcAD1SuioC3kzSN+F/mDYnWP+S3NOA4scpnJxeNP1lC76ooDG0yL7fpAkZLSL7WNmb0X73bkDfajT5JaBmZ0wIDAQAB";
  // 应用私钥:
  public static final String app_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCo/14l4hI/Wy1ZfhjlVcm2jYxT0k5PDLGAX7JK1xjVSXwE8jVOvBvkMjD9h5grMU9SdWwbFlcC+f2qZ2lCCq97Q/lO/7udLdo1YpY4rZ6gOKOZkukICajWRWpElX31CknhqStrAcJughzFMIKg/5eDIk0ngBFX0dTXKz+TTg8+vagruy+bEgpSXUl3FBgwehGLduwnl7nbK0Zbhi5n3zscBTZG/tBpQCGUo6rhXMYR28RiuOA1XNathyYiqvsbLVk4dDQj/J+1BJF25kqRKtbyT3bU7MvSAnxcur720lVfXlvbZnlGAJW9+G3Zdwji/SgoakGDdXyBhZ5cuF7OLq5nAgMBAAECggEAZ/didi/URgHTrmCy9DOIurPuBos0/dCzSmSVDRGzB1QD5g8T2HJFPmfaV76ZUMkvIW13qlpeAUjGU5T23lgwiMbSk1UkmJfizEDwZcH5+lud2hbVIcq/gcKGk9bb/Gnt9dPbECOu98k35d/oHR/gmB38FTbmdH50UEMdA4RcQJ3w8WB76Fpbr0PPN7oayys4V55RA9YBZqAOV4rncA60DrAFBnjT99nvQBur07Y7EMQSQjxnuGE6gZbzDebJwAHY3jyzzmr6D7/BbFQHwmEOKeoQ5lWKzo/e0PrlAyQedDTMfU9olqmL8NPZEiBDA2mqUhboukBVTl4mJW2eCkvZcQKBgQDQC+HTIcg2gh2PaHBvXWVMbNFnQMCZ8lImlC6fUTf0ALclL7RrCycm1gZs17PLc2Xnjn0GXhX1h68g6Fa+lSdc/puVbE4LbsPZRElnJbH+nvwkJWc7mSe6gHdws0XjdcLFTwNmr9nAAVsGM0knG6xfkf3cV/4lmEes3Qg4DpDSSwKBgQDP81eyIt6lsWS6ji4Z44N7vUQgTIcc4hh/uPVz3ktPgS0aFCrmSLAHD/icw4kctaeCZa81liZwxNBb2vXSPX0vhFDq8VfkehqqbnEGerFqcnzK+yrIiquPEk/W+AUtZi1rYjbRLF4pKsfIQDxNAuhpbCp4IoGxKKOYjq/p2C1i1QKBgDp/DMjrl7rTzPH0oKB/dysM8bgBeeYPP0//nDhJgt0FknlPN4Bdi22dAgN6huAumzmHU9oFfFEkDHbJPRKrJ307TY2u/SazxzeAvs7Ux35bP3P+XE9imcwTsQGsNntlMhV+SOuHiEc3Wluc8fWgD1Bz4RgiWaBCd+y/3T69wbSPAoGANvxANwETYDqcyNtpgzzuelycU/IIU/HQyozskhu4TCh69YdZpJSZvvRRJ5poeefqiAc9Ie028uCHu5IVJ+dMX7Eb+FOiiu5ieKhFSJJOsTfemYl6UZahMG6GH/Bq5gs7fUZ1+i9CIp6GPwQFLdPUAnQwcp2lL2PwhhlMmIep0JUCgYAOiQIe51nB/0jeZ8rj/fVl6qkdqLc5H+NCWpt1RogsJw7GDhVpKti7jkS1GPiANattIXvk8S9qq2HxLRXdDKDv6W0mlp86NtVHbaIzUG/t4QUtfCGCAh7EHw9d1AuMbMYSUGHoO7GkAMb0m5kFRw2rTq60d97ESRGvDhaxN905ng==";
  // 签名方式
  public static final String sign_type = "RSA2";

  public static final String aes_key_dev ="e5A+G8i785XtT6O/rUBnaQ==";
  public static final String aes_key = "wouQP85VfOQtaGwrOn9CgA==";
  // 字符编码格式
  public static final String charset = "utf-8";
  public static final String return_url = "https://3b973ce7.r15.cpolar.top";
  public static final String notify_url = "https://3b973ce7.r15.cpolar.top";
  public static  AlipayConfig alipayConfig;
  static {
    alipayConfig = new AlipayConfig();
    alipayConfig.setReadTimeout(10000);
    alipayConfig.setConnectTimeout(10000);
    alipayConfig.setAlipayPublicKey(AliPayData.alipay_public_key_dev);
    alipayConfig.setCharset(AliPayData.charset);
    alipayConfig.setAppId(AliPayData.app_id_dev);
    alipayConfig.setPrivateKey(AliPayData.app_private_key);
    alipayConfig.setSignType(AliPayData.sign_type);
    alipayConfig.setServerUrl(AliPayData.alipay_gateway_address_dev);
    alipayConfig.setEncryptKey(AliPayData.aes_key_dev);
  }
  public AlipayConfig getConfig(){
    return alipayConfig;
  }
}
