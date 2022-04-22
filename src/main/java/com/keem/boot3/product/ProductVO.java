package com.keem.boot3.product;

import java.util.List;

import lombok.Data;

@Data
public class ProductVO {

	
	private Long productNum;
	private String productName;
	private Integer productPrice;
	private Integer productCount;
	private String productDetail;

	private ProductFilesVO productFilesVO;
	private List<ProductFilesVO> productFilesVOs;
}
