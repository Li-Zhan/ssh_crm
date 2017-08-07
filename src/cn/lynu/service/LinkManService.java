package cn.lynu.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lynu.dao.LinkManDao;
import cn.lynu.dao.VisitDao;
import cn.lynu.model.LinkMan;
import cn.lynu.model.Visit;

@Transactional
public class LinkManService {
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	public void add(LinkMan linkMan) {
		linkManDao.add(linkMan);
	}

	public List<LinkMan> findAll() {
		return linkManDao.findAll();
	}

	public LinkMan findById(int lid) {
		return linkManDao.findById(lid);
	}

	public void update(LinkMan linkMan) {
		linkManDao.update(linkMan);
	}

	public List<LinkMan> selectLinkman(LinkMan linkMan) {
		return linkManDao.selectLinkMan2(linkMan);
	}

}
