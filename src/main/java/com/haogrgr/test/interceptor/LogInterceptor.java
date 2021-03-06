package com.haogrgr.test.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.haogrgr.test.exception.BizException;

@Aspect
@Component
public class LogInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    
    @Pointcut("execution(* com.haogrgr.test.server..*.*(..))")
    public void logPointcut(){}
    
    @AfterThrowing(value="logPointcut()", throwing="t")
    public void doLogging(JoinPoint joinPoint, Throwable t) {
        if(t instanceof BizException){
        	BizException be = (BizException) t;
            logger.error("\nlog aop : " + getDebugInfo(joinPoint) + "\ndebug : " + be.getMsg() + "\nmsg : " + be.getMessage());
        }else{
            logger.error("log aop : " + getDebugInfo(joinPoint), t);
        }
    }
    
    private static String getDebugInfo(JoinPoint joinPoint){
        String result = joinPoint.toLongString() + " args : ";
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            result = result + (arg == null ? "null" : arg.toString()) + ", ";
        }
        return result;
    }
    
}
