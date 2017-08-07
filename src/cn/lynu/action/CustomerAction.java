package cn.lynu.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lynu.model.Customer;
import cn.lynu.model.Dict;
import cn.lynu.model.PageBean;
import cn.lynu.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private CustomerService customerService;
	
	private Customer customer=new Customer();
	
	//分页(首页)
	private int currPage=1;


	public int getCurrPage() {
		return currPage;
	}


	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	public Customer getModel() {
		return customer;
	}
	
	/**
	 * 到添加页面
	 * @return
	 */
	public String toAddPage(){
		List<Dict> listDict=customerService.findAllDict();
		ServletActionContext.getRequest().setAttribute("listDict", listDict);
		return "toAddPage";
	}
	
	/**
	 * 添加客户
	 * @return
	 */
	public String add(){
		//boolean b=
		customerService.add(customer);
		//if(b=true){
			return "add";
		//}
		//return "addError";
	}
	
	//放入值栈方式2.1
	private List<Customer> list;
	public List<Customer> getList() {
		return list;
	}


	/**
	 * 客户列表
	 * @return
	 */
	public String list(){
		//List<Customer> list=customerService.list();
		//放入域对象
		//ServletActionContext.getRequest().setAttribute("list", list);
		//放入值栈方法1
		//ActionContext.getContext().getValueStack().push(list);
		//放入值栈方式2.2
		list=customerService.list();
		return "list";
	}
	
	
	/**
	 * 删除客户	
	 */
	public String delete(){
		int id=customer.getCid();
		//if(
				customerService.delete(id);
			//	){
			return "delete";
		//}
		//return "delete";
	}
	
	/**
	 * 转跳到编辑客户页面
	 */
	public String showEdit(){
		Customer c=customerService.showEdit(customer.getCid());
		ServletActionContext.getRequest().setAttribute("customer", c);
		return "showEdit";
	}
	
	/**
	 * 修改客户操作
	 */
	public String update(){
		customerService.update(customer);
		return "update";
	}
	
	/**
	 * 分页操作
	 */
	public String listPage(){
		PageBean<Customer> pageBean=customerService.listPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "listPage";
	}
	
	/**
	 * 条件查询
	 */
	public String listCondition(){
		if(customer.getCustName()!=null&&!"".equals(customer.getCustName())){
			//List<Customer> 
			list=customerService.findCondition(customer.getCustName());
			//ServletActionContext.getRequest().setAttribute("list", list);
		}else{
			list = customerService.list();
		}
		return "listCondition";
	}
	
	
	/**
	 * 转跳到查询页
	 * @return
	 */
	public String toSelectPage(){
		return "toSelectPage";
	}
	
	/**
	 * 多条件查询
	 */
	public String select(){
		//List<Customer> 
		list=customerService.select(customer);
		//System.out.println("*********"+list.size());
		//ServletActionContext.getRequest().setAttribute("list", list);
		ActionContext.getContext().getValueStack().push(list);
		return "select";
	}
	
	/**
	 * 客户来源统计
	 * @return
	 */
	public String countSource(){
		List<Map> list=customerService.findCountSource();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countSource";
	}
	
	/**
	 * 客户级别统计
	 */
	public String countLevel(){
		List list=customerService.findCountLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countLevel";
	}
}
