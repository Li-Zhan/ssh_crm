package cn.lynu.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lynu.model.User;
import cn.lynu.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private UserService userService;

	private User user = new User();

	public User getModel() {
		return user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() {
		User u = userService.login(user);
		if (u != null) {
			ActionContext.getContext().getSession().put("user", u);
			return "loginSuccess";
		} else {
			return "loginError";
		}
	}

}
