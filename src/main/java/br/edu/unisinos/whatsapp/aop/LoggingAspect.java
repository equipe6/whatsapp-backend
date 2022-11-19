package br.edu.unisinos.whatsapp.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private final Logger logger = LogManager.getLogger(LoggingAspect.class);

    private String buildPrefixLogMsg(JoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringTypeName() + ":" + joinPoint.getSignature().getName();
    }

    @Pointcut("@annotation(Log)")
    public void logPointcut() {
    }

    @After("logPointcut()")
    public void logAllMethodAfterCallsAdvice(JoinPoint joinPoint) {
        logger.info(this.buildPrefixLogMsg(joinPoint) + " - After call Advice");
    }

    @Before("logPointcut()")
    public void logAllMethodBeforeCallsAdvice(JoinPoint joinPoint) {
        logger.info(this.buildPrefixLogMsg(joinPoint) + " - Before Call Advice");
    }


    @AfterReturning(value = "execution(* br.edu.unisinos.whatsapp.controllers.MessageController.*(..))", returning = "result")
    public void logMessagesAfterAPICall(JoinPoint joinPoint, Object result) {
        logger.info(this.buildPrefixLogMsg(joinPoint) + "AOP Method Name :" + joinPoint.getSignature().getName());
        logger.info(this.buildPrefixLogMsg(joinPoint) + "AOP Return Value  :" + result);
    }

    @AfterThrowing(pointcut = "execution(* br.edu.unisinos.whatsapp.*.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(JoinPoint joinPoint, Throwable ex) throws Throwable {
        logger.error(this.buildPrefixLogMsg(joinPoint) + "Exception: " + ex);
    }

}
