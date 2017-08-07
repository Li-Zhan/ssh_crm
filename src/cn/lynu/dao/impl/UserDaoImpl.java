package cn.lynu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lynu.dao.UserDao;
import cn.lynu.model.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	//登录
	public User login(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where userName=? and password=?", user.getUserName(),user.getPassword());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
//	private HibernateTemplate hibernateTemplate;
//
//	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//		this.hibernateTemplate = hibernateTemplate;
//	}

	//查询所有
//	public List<User> findAll() {
//		return (List<User>) this.getHibernateTemplate().find("from User");
//	}
	
	

}
