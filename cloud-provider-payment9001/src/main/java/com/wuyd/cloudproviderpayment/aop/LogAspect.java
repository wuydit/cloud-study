package com.wuyd.cloudproviderpayment.aop;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 切面日志,不要在查询中使用,只可以在修改或者删除使用,避免造成日志臃肿
 * @author wuyd
 * 创建时间：2019/10/23 15:38
 */

@Slf4j
@Aspect
@Component
public class LogAspect {


    private final ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 切点
     */
    @Pointcut("@annotation(com.wuyd.cloudproviderpayment.aop.Log)")
    public void controllerAspect() {
    }


    /**
     * 切面
     */
    @Before("controllerAspect()")
    public void before(JoinPoint point) throws Throwable {

        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        @SuppressWarnings("all")
        HttpServletRequest request = attributes.getRequest();
        log.info("REQ[{}],IP[{}],ARGS[{}],URL[{}]",
                getMethodDescription(point),
                request.getLocalAddr(),
                Arrays.toString(point.getArgs()),
                request.getRequestURL().toString());
    }

    @SuppressWarnings("all")
    @AfterReturning(returning = "ret", pointcut = "controllerAspect()")
    public void doAfterReturning(Object ret) {
        log.info("RES ms[{}], {}", (System.currentTimeMillis() - startTime.get()), ret);
        startTime.remove();
    }

    /**
     * 获取方法中的中文备注
     *
     * @param joinPoint 切点
     */
    @SuppressWarnings("all")
    private static String getMethodDescription(JoinPoint joinPoint) throws Exception {

        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        Class targetClass = Class.forName(targetName);
        Method[] method = targetClass.getMethods();
        String methode = "";
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    Log methodCache = m.getAnnotation(Log.class);
                    if (methodCache != null) {
                        methode = methodCache.value();
                    }
                    break;
                }
            }
        }
        return methode;
    }

}
