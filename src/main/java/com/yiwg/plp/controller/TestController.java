package com.yiwg.plp.controller;

import com.yiwg.plp.po.AjaxPo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

	@RequestMapping(value = "/test")
	@ResponseBody
	public Object test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AjaxPo res = new AjaxPo();
		return res;
	}
}