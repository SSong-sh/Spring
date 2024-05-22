package com.test.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component //<bean>
@Aspect //<aop:aspect ref="logger">
public class Logger {
	
	//포인트컷
	//OOOAdvice > 결합

}
