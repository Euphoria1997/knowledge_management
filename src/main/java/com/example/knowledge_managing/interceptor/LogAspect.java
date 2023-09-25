package com.example.knowledge_managing.interceptor;

import org.apache.ibatis.binding.MapperMethod;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
//使用aop的举例
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.example.knowledge_managing.controller.*.*(..))")
    public void printLog(){
    }

//	@Before("printLog()")
//	public void before(JoinPoint joinPoint)
//	{
//		System.out.println("before执行....."+joinPoint.getSignature().getDeclaringTypeName());
//		System.out.println("执行方法名:"+joinPoint.getSignature().getName());
//		System.out.println("执行类名:"+joinPoint.getTarget().getClass().getSimpleName());
//		System.out.println("执行类名:"+joinPoint.getSignature().getDeclaringType().getSimpleName());
//		Object[] args = joinPoint.getArgs();
//        System.out.println(" begin with:" + Arrays.asList(args));
//	}


    //括号里也可以直接写成：@Around("execution(public * com.stuPayment.uiController..*.*(..))") 即括号里是切入点
    @Around ("printLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable
    {
        //ProceedingJoinPoint:织入增强处理的连接点JoinPoint的子类。我们可以把这个看作是切入点的那个方法的替身
        String str=pjp.getSignature().getDeclaringTypeName()+"."+pjp.getSignature().getName();
        MethodSignature methodSignature=(MethodSignature) pjp.getSignature();//获取方法的签名
        String[] values=methodSignature.getParameterNames();//获取参数名称
        Object[] args = pjp.getArgs();//获取参数值
        StringBuffer sBuffer=new StringBuffer();
        for(int i=0;i<values.length;i++)
        {
            sBuffer.append("{"+values[i]+":"+args[i]+"}");
        }
        logger.info("方法:"+str+"开始执行,参数为:"+sBuffer.toString());
        long begin = System.currentTimeMillis();
        Object object=pjp.proceed();
        long end = System.currentTimeMillis();
        logger.info("方法:"+str+"执行结束,共耗时:"+(end - begin)+"毫秒");
        return object;
    }
}