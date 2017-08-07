package cn.lynu.dao;

import java.util.List;
import java.util.Map;

import cn.lynu.model.Customer;
import cn.lynu.model.Dict;

public interface CustomerDao {

	Customer findByCustName(String custName);

	void add(Customer customer);

	List<Customer> list();

	Customer findById(int cid);

	void delete(Customer customer);

	void update(Customer customer);

	int findCount();

	List<Customer> findPage(int begin, int pageSize);

	List<Customer> findCondition(String custName);

	List<Customer> select(Customer customer);
	
	List<Customer> selectCustomer(Customer customer);

	List<Dict> findAllDict();

	List<Map> findCountSource();

	List findCountLevel();

}
