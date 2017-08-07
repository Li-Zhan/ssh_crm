package cn.lynu.dao;

import java.util.List;

import cn.lynu.model.LinkMan;
import cn.lynu.model.Visit;

public interface LinkManDao {

	void add(LinkMan linkMan);

	List<LinkMan> findAll();

	LinkMan findById(int lid);

	void update(LinkMan linkMan);

	List<LinkMan> selectLinkMan(LinkMan linkMan);

	List<LinkMan> selectLinkMan2(LinkMan linkMan);
}
