package com.keem.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.keem.boot3.util.FileManager;
import com.keem.boot3.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private FileManager fileManager;

	public List<ProductVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		Integer totalCount = productMapper.total(pager);
		pager.makenum(totalCount);
		List<ProductVO> ar = productMapper.getList(pager);
		return ar;
	}

	public int setAdd(ProductVO productVO, MultipartFile[] files) throws Exception {
		System.out.println("Insert 전: " + productVO.getProductNum());
		int result = productMapper.setAdd(productVO);
		System.out.println("Insert 후:" + productVO.getProductNum());
		if (files != null) {
			for (MultipartFile mf : files) {
				if (mf.isEmpty()) {
					continue;
				}
				// File을 하드디스크에 저장
				String fileName = fileManager.fileSave(mf, "resources/upload/product/");

				// 저장된 정보를 DB에 저장
				ProductFilesVO productFilesVO = new ProductFilesVO();
				productFilesVO.setProductNum(productVO.getProductNum());
				productFilesVO.setFileName(fileName);
				productFilesVO.setOriName(mf.getOriginalFilename());
				productMapper.setFileAdd(productFilesVO);

			}
		}
		return result;
	}
}
