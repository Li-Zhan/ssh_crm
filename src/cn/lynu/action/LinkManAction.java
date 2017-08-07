package cn.lynu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lynu.model.Customer;
import cn.lynu.model.LinkMan;
import cn.lynu.service.CustomerService;
import cn.lynu.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkManService linkManService;
	
	private LinkMan linkMan=new LinkMan();

	//添加客户service
	private CustomerService customerService;
	
	//文件上传
	private File upload;
	//文件上传名(固定格式文件变量名+FileName)
	private String uploadFileName;

	public File getUpload() {
		return upload;
	}


	public void setUpload(File upload) {
		this.upload = upload;
	}


	public String getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}


	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	

	public LinkMan getModel() {
		return linkMan;
	}



	/**
	 * 转跳到添加页面
	 * @return
	 */
	public String toAddPage(){
		//将客户放入域对象，在页面用下拉列表显示
		List<Customer> listCustoner = customerService.list();
		ServletActionContext.getRequest().setAttribute("listCustoner", listCustoner);
		//ActionContext.getContext().getValueStack().push(listCustoner);
		return "toAddPage";
	}
	
	/**
	 * 添加联系人
	 * @return
	 * @throws Exception 
	 */
	public String add() throws Exception{
		if(upload!=null){
			File newFile=new File("D:\\abc"+File.separatorChar+uploadFileName);
			FileUtils.copyFile(upload, newFile);
//			InputStream is=new FileInputStream(getUpload()); //根据上传的文件得到输入流
//			OutputStream os=new FileOutputStream("D:\\abc"+File.separatorChar+uploadFileName);//指定输出位置
//			byte buffer[]=new byte[1024];
//			int count=0;
//			while((count=is.read(buffer))!=-1){
//				os.write(buffer,0,count);        //把文件写到指定位置的文件中
//			}
//			os.close();
//			is.close();
		}
		linkManService.add(linkMan);
		return "add";
	}
	
	/**
	 * 转跳到列表
	 */
	public String toListPage(){
		List<LinkMan> list=linkManService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toListPage";
	}
	
	/**
	 * 转跳到修改页面
	 */
	public String toUpdate(){
		LinkMan linkman=linkManService.findById(linkMan.getLid());
		List<Customer> Listcustomer = customerService.list();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Listcustomer", Listcustomer);
		request.setAttribute("linkman", linkman);
		return "toUpdate";
	}

	/**
	 * 修改联系人
	 */
	public String update(){
		linkManService.update(linkMan);
		return "update";
	}
	
	public String toSelectPage(){
		List<Customer> list = customerService.list();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toSelectPage";
	}
	
	/**
	 * 多条件查询
	 */
	public String selectLinkman(){
		List<LinkMan> list=linkManService.selectLinkman(linkMan);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "selectLinkman";
	}
}
