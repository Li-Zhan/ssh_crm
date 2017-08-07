package cn.lynu.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import cn.lynu.dao.CustomerDao;
import cn.lynu.model.Customer;
import cn.lynu.model.Dict;
import cn.lynu.model.PageBean;

@Transactional
public class CustomerService {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void add(Customer customer) {
		if(customerDao.findByCustName(customer.getCustName())==null){
			customerDao.add(customer);
		}
	}

	public List<Customer> list() {
		List<Customer> list=customerDao.list();
		return list;
	}

	public void delete(int id) {
		Customer c = customerDao.findById(id);
		if(c!=null){
			customerDao.delete(c);
			//return true;
		}
		//return false;
	}

	public Customer showEdit(int cid) {
		Customer customer = customerDao.findById(cid);
		return customer;
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	public PageBean<Customer> listPage(int currPage) {
		PageBean<Customer> pageBean=new PageBean<>();
		//封装
		pageBean.setCurrPage(currPage);
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		int totalCount=customerDao.findCount();
		pageBean.setTotalCount(totalCount);
//		Double totalPage=Math.ceil((double)totalCount/pageSize);
//		pageBean.setTotalPage(totalPage.intValue());
		//每页开始
		int begin=(currPage-1)*pageSize;
		List<Customer> list=customerDao.findPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public List<Customer> findCondition(String custName) {
		List<Customer> list=customerDao.findCondition(custName);
		return list;
	}

	public List<Customer> select(Customer customer) {
		return customerDao.selectCustomer(customer);
	}

	public List<Dict> findAllDict() {
		return customerDao.findAllDict();
	}

	public List<Map> findCountSource() {
		return customerDao.findCountSource();
	}

	public List findCountLevel() {
		return customerDao.findCountLevel();
	}
	
	
}
