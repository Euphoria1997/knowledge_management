package com.example.knowledge_managing.util;

public class RespPage {
	
	private long totalCount = 0;
	private long pageSize = 0;
	
	
	public RespPage(long totalCount, long pageSize) {
		super();
		this.totalCount = totalCount;
		this.pageSize = pageSize;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	

	
	

}
