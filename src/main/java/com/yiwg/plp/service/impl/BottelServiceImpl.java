package com.yiwg.plp.service.impl;

import com.yiwg.plp.dao.BottelDaoI;
import com.yiwg.plp.exception.ServiceException;
import com.yiwg.plp.model.Bottel;
import com.yiwg.plp.model.User;
import com.yiwg.plp.service.BaseService;
import com.yiwg.plp.service.BottelServiceI;
import com.yiwg.plp.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
*@date:2016/12/11
*@className:BottelServiceImpl
*@author：yiweiguo
*@description:
*/
@Service("bottelService")
public class BottelServiceImpl extends BaseService implements BottelServiceI {

    @Autowired
    private BottelDaoI bottelDao;
    @Autowired
    private UserServiceI userService;

    @Override
    public void save(Bottel bottel, User user)throws Exception{
        try {
            user=userService.getByNick(user);
            bottel.setFrom(user);
            bottelDao.saveOrUpdate(bottel);
        } catch (Exception e) {
            logger.warn("数据库出错");
            throw new ServiceException("数据库出错");
        }
    }
}
