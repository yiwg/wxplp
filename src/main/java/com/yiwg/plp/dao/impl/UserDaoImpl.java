package com.yiwg.plp.dao.impl;

import com.yiwg.plp.dao.UserDaoI;
import com.yiwg.plp.model.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDaoI {

}
