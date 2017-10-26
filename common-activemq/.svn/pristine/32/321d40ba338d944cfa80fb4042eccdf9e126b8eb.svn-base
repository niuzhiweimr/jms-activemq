package com.mq.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//获取上下文
public class FatchApplicationContext {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		FatchApplicationContext.applicationContext = applicationContext;
	}

}
