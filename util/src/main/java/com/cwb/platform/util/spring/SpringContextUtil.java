package com.cwb.platform.util.spring;

import lombok.experimental.var;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

@Component
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext ;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static <T> T getBean(Class<T> t){
		if (applicationContext == null) return null;
		return applicationContext.getBean(t);
	}

	public static Object getBean(String name){
		return applicationContext.getBean(name);
	}

	public static Map<String,Object> getByAnnotation(Class<? extends Annotation> cls){
		return applicationContext.getBeansWithAnnotation(cls);
	}
}
