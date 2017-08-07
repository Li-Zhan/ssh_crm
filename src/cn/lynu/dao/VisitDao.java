package cn.lynu.dao;

import java.util.List;

import cn.lynu.model.Visit;

public interface VisitDao {

	void addVisit(Visit visit);

	List<Visit> findAll();

	List<Visit> select(Visit visit);

}
