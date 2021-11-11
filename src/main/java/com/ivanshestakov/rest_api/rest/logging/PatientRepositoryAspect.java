package com.ivanshestakov.rest_api.rest.logging;

import com.ivanshestakov.rest_api.rest.controller.PatientController;
import com.ivanshestakov.rest_api.rest.repository.PatientDAOImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PatientRepositoryAspect {

    private final static Logger log = LogManager.getLogger(PatientDAOImpl.class);

}
