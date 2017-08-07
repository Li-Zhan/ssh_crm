package cn.lynu.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lynu.dao.UserDao;
import cn.lynu.model.User;

@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(User user) {
		return userDao.login(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}
	
	

}
