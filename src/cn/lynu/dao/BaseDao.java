package cn.lynu.dao;

import java.util.List;

public interface BaseDao<T> {
	
	public void add(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public T findOne(int id);
	
	public List<T> findAll();

}
