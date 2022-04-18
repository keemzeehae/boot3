package com.keem.boot3.util;

import lombok.Data;

@Data
public class Pager {

	// DB에서 몇개씩 조회
	private Integer perPage;
	
	// DB에서 조회할 시작 번호
	private Integer startRow;
	
	// page 번호  (파라미터 값으로 세팅)
	private Integer pn;
	
	public void makeRow() {
		//pn : 1, perPage : 10, startRow : 0
		//pn : 2, perPage : 10, startRow : 10
		//pn : 3, perPage : 10, startRow : 20
		this.startRow=(this.getPn()-1)*this.getPerPage();
		
	}

	public Integer getPn() {
		if(this.pn==null|| this.pn<1) {
			this.pn=1;
		}
		return this.pn;
	}
	
	
	public Integer getPerPage() {
		if(this.perPage==null || this.perPage<1) {
			this.perPage=10;
			
		}
		return this.perPage;
	}
	
}
