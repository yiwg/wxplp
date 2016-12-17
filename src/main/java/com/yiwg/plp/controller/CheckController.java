package com.yiwg.plp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yiwg.plp.po.AjaxPo;
import com.yiwg.plp.service.UserServiceI;
import com.yiwg.plp.util.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CheckController extends BaseController {

	@Autowired
	private UserServiceI userService;
	@RequestMapping(value = "/check")
	@ResponseBody
	public AjaxPo check(HttpServletRequest request, HttpServletResponse response,String content) {
		AjaxPo res = new AjaxPo();
		try {
			String rps=CaptchaUtil.checkText(content);
			JSONObject jsonObject = JSON.parseObject(rps);
			logger.debug("jsonObject:"+jsonObject);
			int code = (int)jsonObject.get("code");
			String msg =(String) jsonObject.get("msg");
			if (code == 200) {
				JSONObject resultObject =(JSONObject)jsonObject.get("result");
				int action = (int)resultObject.get("action");
				if (action == 1) {
					logger.info("{}:正常内容，通过",content);
					res.setSuccess(1,"正常内容，通过");
				} else if (action == 2) {
					logger.info("{}:垃圾内容，删除",content);
					res.setSuccess(2,"垃圾内容，删除");
				} else if (action == 3) {
					logger.info("{}:嫌疑内容",content);
					res.setSuccess(3,"嫌疑内容");
				}
			} else {
				logger.warn("网络请求失败");
				res.setFailed(code,"网络请求失败");
			}
		} catch (Exception e) {
			logger.info("检测失败",e);
			res.setFailed(-1,"检测失败");
			return res;
		}
		return res;
	}
}