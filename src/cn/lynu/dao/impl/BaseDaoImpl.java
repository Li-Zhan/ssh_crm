package cn.lynu.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lynu.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class pClass;

	
	public BaseDaoImpl() {
		//第一步，得到当前运行类的class
		Class clazz = this.getClass();
		//第二步，得到运行类的父类的参数化类型
		Type type = clazz.getGenericSuperclass();
		ParameterizedType pType=(ParameterizedType) type;
		//第三步，得到实际类型参数
		Type[] types = pType.getActualTypeArguments();
		Class tClass= (Class) types[0];
		this.pClass=tClass;
	}

	//添加
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	//更新
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	//删除
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	//根据Id查询
	public T findOne(int id) {
		return (T) this.getHibernateTemplate().get(pClass, id);
	}

	//查询所有
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+pClass.getSimpleName());
	}

}
