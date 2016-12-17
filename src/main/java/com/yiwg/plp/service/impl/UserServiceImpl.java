package com.yiwg.plp.service.impl;

import com.yiwg.plp.dao.UserDaoI;
import com.yiwg.plp.exception.ServiceException;
import com.yiwg.plp.model.User;
import com.yiwg.plp.service.BaseService;
import com.yiwg.plp.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/*
*@date:2016/12/11
*@className:BottelServiceImpl
*@author：yiweiguo
*@description:
*/

@Service("userService")
public class UserServiceImpl extends BaseService implements UserServiceI {

    @Autowired
    private UserDaoI userDao;
    @Override
    public User getByNick(User user) throws ServiceException {
        logger.debug("进入UserServiceImpl.getByNick,参数为:"+user);
        String hql="from User t where t.nickName = :nick";
        Map<String,Object> param=new HashMap<>();
        param.put("nick",user.getNickName());
        try {
            user = userDao.get(hql,param);
        } catch (Exception e) {
            logger.warn("数据库出错",e);
            throw new ServiceException("数据库出错");
        }
        return user;
    }

    @Override
    public void save(User user) throws Exception{
        logger.debug("进入UserServiceImpl.save,参数为:"+user);
        try {
            userDao.save(user);
        } catch (Exception e) {
            logger.warn("数据库出错",e);
            throw new ServiceException("数据库出错");
        }
    }
}
