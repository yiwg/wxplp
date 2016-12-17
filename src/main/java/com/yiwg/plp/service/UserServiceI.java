package com.yiwg.plp.service;

import com.yiwg.plp.exception.ServiceException;
import com.yiwg.plp.model.User;

public interface UserServiceI {
	public User getByNick(User  User) throws ServiceException;
	public void save(User user) throws Exception;
}
