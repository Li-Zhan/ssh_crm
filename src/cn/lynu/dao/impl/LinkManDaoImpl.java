package cn.lynu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lynu.dao.LinkManDao;
import cn.lynu.model.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {


	public void add(LinkMan linkMan) {
		this.getHibernateTemplate().save(linkMan);
	}


	public List<LinkMan> findAll() {
		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}



	public LinkMan findById(int lid) {
		return this.getHibernateTemplate().get(LinkMan.class, lid);
	}



	public void update(LinkMan linkMan) {
		this.getHibernateTemplate().update(linkMan);
	}
 

	//多条件查询(拼接hql语句)
	public List<LinkMan> selectLinkMan(LinkMan linkMan) {
		String hql="from LinkMan where 1=1 ";
		List<Object> pList=new ArrayList<Object>();
		if(linkMan.getLkmName()!=null&&!"".equals(linkMan.getLkmName())){
			hql+=" and lkmName=?";
			pList.add(linkMan.getLkmName());
		}
		if(linkMan.getCustomer().getCid()!=null&&linkMan.getCustomer().getCid()>0){
			hql+=" and customer.cid=?";
			pList.add(linkMan.getCustomer().getCid());
		}
		return (List<LinkMan>) this.getHibernateTemplate().find(hql,pList.toArray());
	}
	
	//多条件查询(离线对象) 
	public List<LinkMan> selectLinkMan2(LinkMan linkMan){
		DetachedCriteria criteria=DetachedCriteria.forClass(LinkMan.class);
		if(linkMan.getLkmName()!=null&&!"".equals(linkMan.getLkmName())){
			criteria.add(Restrictions.eq("lkmName", linkMan.getLkmName()));
		}
		if(linkMan.getCustomer().getCid()!=null&&linkMan.getCustomer().getCid()>0){
			criteria.add(Restrictions.eq("customer.cid", linkMan.getCustomer().getCid()));
		}
		return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
	}


}
