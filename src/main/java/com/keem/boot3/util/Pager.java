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
	
	
	//--------------검색기능
	private String search;
	private String kind;
	
	
	//-----------------JSP사용변수
	private Integer startNum;
	private Integer lastNum;
	
	private boolean pre;
	private boolean next;
	
	public void makeRow() {
		//pn : 1, perPage : 10, startRow : 0 lastRow : 9
		//pn : 2, perPage : 10, startRow : 10 lastRow : 19
		//pn : 3, perPage : 10, startRow : 20 lastRow : 29
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
	// Getter : get + 멤버변수명, 멤버변수명의 첫글자는 대문자
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
			return this.search;
	}
	
	public void makenum(Integer totalCount) {
		// 전체 row의 갯수 구해옴
		
		// 전체 page 의 갯수 구하기
		Integer totalPage=totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage++;
			
		}
		// 블럭당 갯수 블럭 의미: 아래 보여지는 번호 
		Integer perBlock=5;
		
		// 전체 블럭의 갯수
		Integer totalBlock=totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
			
		}
		// page번호로 현재 몇번째 Block인지 계산
		Integer curBlock = this.getPn()/perBlock;
		if(this.getPn()%perBlock!=0) {
			curBlock++;
		}
		
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
		
		// 이전, 다음 블럭의 유무를
		this.pre=false;
		if(curBlock>1) {
			this.pre=true;
		}
		
		this.next=false;
		if(totalBlock>curBlock) {
			this.next=true;
		}
		
		// 현재 블럭이 마지막 블럭번호와 같다면
		if(curBlock==totalBlock) {
			this.lastNum=totalPage;
		}
	}
}
