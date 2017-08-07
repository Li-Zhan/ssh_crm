package cn.lynu.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lynu.dao.VisitDao;
import cn.lynu.model.Visit;

@Transactional
public class VisitService {
	private VisitDao visitDao;

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	public void addVisit(Visit visit) {
		visitDao.addVisit(visit);
	}

	public List<Visit> findAll() {
		return visitDao.findAll();
	}

	public List<Visit> select(Visit visit) {
		return visitDao.select(visit);
	}
	
	

}
