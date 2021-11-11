package com.ivanshestakov.rest_api.rest.logging;

import com.ivanshestakov.rest_api.rest.controller.PatientController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.Optional;


@Component
@Aspect
public class PatientControllerAspect {
    private final static Logger log = LogManager.getLogger(PatientController.class);

    @Pointcut("execution(*  com.ivanshestakov.rest_api.rest.controller.PatientController.get*(..))")
    private void getControllerMethods(){};

    @Pointcut("execution(*  com.ivanshestakov.rest_api.rest.controller.PatientController.post*(..))")
    private void postControllerMethods(){};

    @Pointcut("execution(*  com.ivanshestakov.rest_api.rest.controller.PatientController.put*(..))")
    private void putControllerMethods(){};

    @Pointcut("execution(*  com.ivanshestakov.rest_api.rest.controller.PatientController.delete*(..))")
    private void deleteControllerMethods(){};


    @Around("getControllerMethods()")
    private Object aroundGetControllerMethodsAdvice(ProceedingJoinPoint jp) throws Throwable {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        Optional<GetMapping> getMappingOptional = Optional.ofNullable(method.getAnnotation(GetMapping.class));
        getMappingOptional.ifPresent(ann -> {
            addLogInfo("GET", ann.value(), method.getName());
        });
        Object obj;
        try {
            obj = jp.proceed();
        } catch (Exception e) {
            log.warn(e.getClass().getSimpleName() +
                    " was thrown with message: " +
                    e.getMessage() +
                    " in method " + method.getName());
            throw e;
        }
        return obj;
    }

    @Around("postControllerMethods()")
    private Object aroundPostControllerMethodsAdvice(ProceedingJoinPoint jp) throws Throwable {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        Optional<PostMapping> postMappingOptional = Optional.ofNullable(method.getAnnotation(PostMapping.class));
        postMappingOptional.ifPresent(ann -> {
            addLogInfo("POST", ann.value(), method.getName());
        });
        Object obj;
        try {
            obj = jp.proceed();
        } catch (Exception e) {
            log.warn(e.getClass().getSimpleName() +
                    " was thrown with message: " +
                    e.getMessage() +
                    " in method " + method.getName());
            throw e;
        }
        return obj;
    }

    private void addLogInfo(final String requestType, String[] urls, String methodName) {
        log.info(requestType + ": " + Arrays.toString(urls) + ", execute: " + methodName);
    }
}
