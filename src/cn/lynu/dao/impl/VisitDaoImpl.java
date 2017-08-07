package cn.lynu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lynu.dao.VisitDao;
import cn.lynu.model.Visit;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

	
	public void addVisit(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}

	
	public List<Visit> findAll() {
		return (List<Visit>) this.getHibernateTemplate().find("from Visit");
	}


	
	public List<Visit> select(Visit visit) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Visit.class);
		if(visit.getUser().getDid()>0){
			criteria.add(Restrictions.eq("user.did", visit.getUser().getDid()));
		}
		if(visit.getCustomer().getCid()!=null&&visit.getCustomer().getCid()>0){
			criteria.add(Restrictions.eq("customer.cid", visit.getCustomer().getCid()));
		}
		return (List<Visit>) this.getHibernateTemplate().findByCriteria(criteria);
	}

}
