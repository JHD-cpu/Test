package com.example.testSpring.config.LoggerConfig;

import com.example.testSpring.Utils.JSONUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoggerInfoAop {

  @Pointcut("execution(public * com.example.testSpring.Controller..*.*(..))")
  public void log() {}


  @Around("log()")
  public Object controllerAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long l = System.currentTimeMillis();
    Logger logger = LoggerFactory.getLogger(proceedingJoinPoint.getSignature().getDeclaringType());
    Object[] args = proceedingJoinPoint.getArgs();
    HttpServletRequest request =
        ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    String contentType = request.getHeader("content-type");
    logger.info("=================http 请求===============");
    logger.info("content-type：" +contentType);
    logger.info("请求地址：" +request.getRequestURI());
    logger.info("请求参数：" + JSONUtils.toJsonString(args));
    logger.info("请求方式：" +request.getMethod());
    logger.info("执行线程：" + Thread.currentThread().getName());
    logger.info(
        "执行方法："
                +proceedingJoinPoint.getSignature().getDeclaringTypeName()
            + "."
            + proceedingJoinPoint.getSignature().getName());

    Object proceed = proceedingJoinPoint.proceed(args);

    logger.info("响应返参：" +  JSONUtils.toJsonString(proceed));
    logger.info("响应耗时：" + (System.currentTimeMillis() - l));
    logger.info("=======================================");
    return proceed;
  }
}
