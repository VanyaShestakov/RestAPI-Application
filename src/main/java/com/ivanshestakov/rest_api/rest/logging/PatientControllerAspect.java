package com.ivanshestakov.rest_api.rest.logging;

import com.ivanshestakov.rest_api.rest.controller.PatientController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


@Component
@Aspect
public class PatientControllerAspect {
    private final static Logger log = LogManager.getLogger(PatientController.class);

    @Around("execution(*  com.ivanshestakov.rest_api.rest.controller.PatientController.get*(..))")
    private Object aroundAllControllerMethodsAdvice(ProceedingJoinPoint jp) throws Throwable {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        Annotation annotation = method.getAnnotation(GetMapping.class);
        log.info("executing " + signature.toShortString());
        Object obj = jp.proceed();
        return obj;
    }

}
