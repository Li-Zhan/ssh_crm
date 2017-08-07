package cn.lynu.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lynu.dao.CustomerDao;
import cn.lynu.model.Customer;
import cn.lynu.model.Dict;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	public Customer findByCustName(String custName) {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where custName=?", custName);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	public List<Customer> list() {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
			return list;
	}


	public Customer findById(int cid) {
		return this.getHibernateTemplate().get(Customer.class, cid);
	}


	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}


	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

	//查询总记录数
	@Override
	public int findCount() {
		String hql="select count(*) from Customer";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//分页(limit)
	@Override
	public List<Customer> findPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	//单条件查询(模糊like)
	@Override
	public List<Customer> findCondition(String custName) {
		//方法一
		//List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where custName like ?", "%"+custName+"%");
		//方法二
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.like("custName", "%"+custName+"%"));
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	//多条件查询
	public List<Customer> select(Customer customer) {
		List<Object> p=new ArrayList<>(); 
		//先编写hql语句，给一个成立条件，以防止用户什么都不输入进行查询报错
		String hql="from Customer where 1=1 ";
		//对查询条件进行判断，不为空则拼接hql语句
		if(customer.getCustName()!=null&&!"".equals(customer.getCustName())){
			hql+=" and custName=?";
			p.add(customer.getCustName());
		}
//		if(customer.getCustLevel()!=null&&!"".equals(customer.getCustLevel())){
//			hql+=" and custLevel=?";
//			p.add(customer.getCustLevel());
//		}
		if(customer.getCustSource()!=null&&!"".equals(customer.getCustSource())){
			hql+=" and custSource=?";
			p.add(customer.getCustSource());
		}
		return (List<Customer>) this.getHibernateTemplate().find(hql,p.toArray());
	}

	//使用离线对象进行多条件查询
	public List<Customer> selectCustomer(Customer customer) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		if(customer.getCustName()!=null&&!"".equals(customer.getCustName())){
			criteria.add(Restrictions.eq("custName", customer.getCustName()));
		}
//		if(customer.getCustLevel()!=null&&!"".equals(customer.getCustLevel())){
//			criteria.add(Restrictions.eq("custLevel", customer.getCustLevel()));
//		}
		if(customer.getCustSource()!=null&&!"".equals(customer.getCustSource())){
			criteria.add(Restrictions.eq("custSource", customer.getCustSource()));
		}
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	
	public List<Dict> findAllDict() {
		return (List<Dict>) this.getHibernateTemplate().find("from Dict");
	}

	
	public List<Map> findCountSource() {
		//复杂操作，使用hibernate不好操作，建议使用底层sql语句
		//1.得到session
		Session session = this.getSessionFactory().getCurrentSession();
		//2.创建SQLQuery对象
		SQLQuery sqlQuery=session.createSQLQuery("select count(*) num,custSource from t_customer group by custSource");
		//将结果放入实体类
		//sqlQuery.addEntity("实体类");
		//因为没有对应的实体类，又根据返回结果的结构，可以将返回结果转成map
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		//返回结果，默认是数组结果，上面我们转成了Map，方便页面取值
		List list = sqlQuery.list();
		return list;
	}

	
	public List findCountLevel() {
		Session session = this.getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery=session.createSQLQuery("select c.num,d.dictname from (select count(*) num,cdid from t_customer group by cdid) c,t_dict d where c.cdid=d.did");
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		return sqlQuery.list();
	}

}
