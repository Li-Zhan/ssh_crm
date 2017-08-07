package cn.lynu.model;

import java.util.List;

public class PageBean<T> {
	//当前页
	private int currPage;
	//每页记录数
	private int pageSize;
	//总记录数
	private int totalCount;
	//数据集合
	private List<T> list;

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	//设置总页数(计算得出)
	public int getTotalPage() {
		Double totalPage=Math.ceil((double)totalCount/pageSize);
		return totalPage.intValue();
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
