package com.yiwg.plp.controller;

import com.yiwg.plp.model.Bottel;
import com.yiwg.plp.model.User;
import com.yiwg.plp.po.AjaxPo;
import com.yiwg.plp.service.BottelServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
*@date:2016/12/11
*@className:BottelController
*@author：yiweiguo
*@description:瓶子相关控制层
*/
@Controller
public class BottelController extends BaseController {

    @Autowired
    private BottelServiceI bottelService;
    @RequestMapping("/writeBottel")
    @ResponseBody
    public AjaxPo writeBottel(HttpServletRequest request, HttpServletResponse response, User user,Bottel bottel){
        AjaxPo res=new AjaxPo();
        try {
            bottelService.save(bottel,user);
            logger.info("漂流瓶[{}]保存存成功已存在",bottel);
            res.setSuccess(1,"用户已存在");
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
