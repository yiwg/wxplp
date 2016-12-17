package com.yiwg.plp.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BeanFactoryUtil implements ServletContextListener {
	private static Log logger = LogFactory.getLog(BeanFactoryUtil.class);
	private static ApplicationContext context;

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent event) {
		logger.info("初始化BeanFactory....");
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		logger.info("初始化BeanFactory....OK.");
	}
	

	public static Object getBean(String beanName) throws Exception {
		if (context == null) {
			logger.warn("ApplicationContext 没有初始化！您无法获得业务处理对象，系统无法正常运行");
			throw new Exception("ApplicationContext 没有初始化！您无法获得业务处理对象，系统无法正常运行");
		}
		try {
			return context.getBean(beanName);
		} catch (BeansException exp) {
			logger.error("读取[" + beanName + "]失败！", exp);
			throw new Exception("读取[" + beanName + "]失败！", exp);
		}
	}
}
