package com.xjw.springboot.admin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class LoginAspect {

    @Pointcut("execution(public * com.xjw.springboot.admin.service..*.*(..))")
    public void pointcut(){ }

    @Before("pointcut()")
    public void dobefore(JoinPoint joinPoint){
        System.out.println("aop--->before,method = "+joinPoint.getSignature().getName());
    }

    @After("pointcut()")
    public void doAfer(JoinPoint joinPoint){
        System.out.println("aop-->after,method = "+joinPoint.getSignature().getName());
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("aop-->around 前");
        joinPoint.proceed();
        System.out.println("aop->around 后");
    }

    @AfterReturning(returning = "aa",pointcut = "pointcut()")
    public void doAfterReturning(Object aa) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("aop-->afterReturning,return value: " + aa);
    }
    @AfterThrowing(value = "pointcut()",throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){
        //目标方法名：
        System.out.println("apo->afterThrowing,"+ exception.getMessage());
    }
}
