package com.yiwg.plp.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseInterceptor extends HandlerInterceptorAdapter {

	private Log logger = LogFactory.getLog(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		logger.debug("进入BaseInterceptor.preHandle()..............");
		response.setContentType("text/plain;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");//允许跨域
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		return super.preHandle(request, response, handler);

		//return super.preHandle(request, response, handler);
	}
	
}
