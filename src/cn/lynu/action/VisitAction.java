package cn.lynu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.regexp.internal.recompile;

import cn.lynu.model.Customer;
import cn.lynu.model.User;
import cn.lynu.model.Visit;
import cn.lynu.service.CustomerService;
import cn.lynu.service.LinkManService;
import cn.lynu.service.UserService;
import cn.lynu.service.VisitService;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
	private Visit visit=new Visit();
	public Visit getModel() {
		return visit;
	}
	
	private VisitService visitService;

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	
	private CustomerService customerService;
	
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	private UserService userService;


	public void setUserService(UserService userService) {
		this.userService = userService;
	}




	public String toAddPage(){
		//显示客户
		List<Customer> listCustomer = customerService.list();
		//显示用户
		List<User> listUser=userService.findAll();
		//数据放入到域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listUser", listUser);
		return "toAddPage";
	}
	
	public String addVisit(){
		visitService.addVisit(visit);
		return "addVisit";
	}
	
	public String findAll(){
		List<Visit> list=visitService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findAll";
	}
	
	public String toSelectPage(){
		List<User> listUser = userService.findAll();
		List<Customer> listCustomer = customerService.list();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listUser", listUser);
		request.setAttribute("listCustomer", listCustomer);
		return "toSelectPage";
	}
	
	public String select(){
		List<Visit> list=visitService.select(visit);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "select";
	}

}
