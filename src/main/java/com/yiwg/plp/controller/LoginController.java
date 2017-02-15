package com.yiwg.plp.controller;

import com.yiwg.plp.model.User;
import com.yiwg.plp.po.AjaxPo;
import com.yiwg.plp.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController extends BaseController {



	@Autowired
	private UserServiceI userService;
	@RequestMapping(value = "/login")
	@ResponseBody
	public AjaxPo login(HttpServletRequest request, HttpServletResponse response,User user) {
		AjaxPo res = new AjaxPo();
		//user.setToken("zgyfjch");
		User u = userService.getByNick(user);
		if(u!=null)
		{
			logger.info("用户【{}】已存在",u.getNickName());
			res.setSuccess(1,"用户已存在");
			return res;
		}
		try {
			userService.save(user);
		} catch (Exception e) {
			logger.warn("用户【{}】保存失败",u.getNickName(),e);
			res.setFailed(-1,"保存用户失败");
			return res;
		}
		logger.info("用户【{}】保存成功",u.getNickName());
		res.setSuccess(2,"保存用户成功");
		return res;
	}
}