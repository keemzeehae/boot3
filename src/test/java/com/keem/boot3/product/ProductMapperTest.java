package com.keem.boot3.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keem.boot3.board.BoardFilesVO;
import com.keem.boot3.util.Pager;
@SpringBootTest
class ProductMapperTest {

	@Autowired
	private ProductMapper productMapper;
	
	//@Test
	void setAdd() throws Exception{
		for(int i=0;i<100;i++) {
			if(i%10==0) {
				Thread.sleep(1000);
			}
			ProductVO productVO = new ProductVO();
			productVO.setProductName("character"+i);
			productVO.setProductPrice(20000+i);
			productVO.setProductCount(10+i);
			productVO.setProductDetail("detailPlus"+i);
			int result = productMapper.setAdd(productVO);
			System.out.println("insert Finish");
		}
	}
	//@Test
	void getList() throws Exception{
		Pager pager=new Pager();
		pager.makeRow();
		List<ProductVO> ar = productMapper.getList(pager);
		System.out.println(ar);
		assertEquals(10,ar.size());
	}
	//@Test
	void setFileAdd() throws Exception{
		ProductFilesVO productFilesVO = new ProductFilesVO();
		productFilesVO.setFileName("first fileName");
		productFilesVO.setOriName("first oriName");
		productFilesVO.setFileNum(1L);
		int result= productMapper.setFileAdd(productFilesVO);
		assertEquals(1, result);
	}

}
