package com.class1804.democustomer.tools;
/**
 * 存放分页相关数据
 */
import java.util.List;

public class PageUtil {
	private int currentPage = 1 ;//当前页码
	private int pageSize = 10 ;//每页显示记录数
	private int totalCount ; //总记录数
	private int totalPageCount ; //总页数
	private List list ; //记录结果
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if(currentPage <= 0) {
			this.currentPage = 1 ;
		}
		else if(currentPage > totalPageCount) {
			this.currentPage = this.totalPageCount ;
		}
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize >= 0) {
			this.pageSize = pageSize;
		}
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		
		if(totalCount > 0) {
			this.totalCount = totalCount;
			this.totalPageCount = (this.totalCount%this.pageSize==0) ? 
			this.totalCount/this.pageSize : this.totalCount/this.pageSize+1 ;
		}
	}


	public int getTotalPageCount() {
		return totalPageCount;
	}


	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
