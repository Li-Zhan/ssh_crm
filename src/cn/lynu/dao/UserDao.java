package cn.lynu.dao;

import java.util.List;

import cn.lynu.model.User;

public interface UserDao extends BaseDao<User>{

	User login(User user);

	//List<User> findAll();

}
