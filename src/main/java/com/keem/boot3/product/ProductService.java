package com.keem.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.keem.boot3.util.FileManager;
import com.keem.boot3.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private FileManager fileManager;
	
	public int setUpdate(ProductVO productVO,MultipartFile [] multipartFiles) throws Exception{
		int result=productMapper.setUpdate(productVO);
		
		if(multipartFiles !=null) {
			
			for(MultipartFile multipartFile:multipartFiles) {
				if(multipartFile.isEmpty()) {
					continue;
				}
				
				ProductFilesVO productFilesVO = new ProductFilesVO();
				
				String fileName=fileManager.fileSave(multipartFile, "/resources/upload/product/");
				productFilesVO.setFileName(fileName);
				productFilesVO.setOriName(multipartFile.getOriginalFilename());
				productFilesVO.setProductNum(productVO.getProductNum());
				result=productMapper.setFileAdd(productFilesVO);
			}
		}
		
		return result;
	}

	public int setFileDelete(ProductFilesVO productFilesVO) throws Exception{
		
		// DB에서 조회
		productFilesVO = productMapper.getFileDetail(productFilesVO);
		
		// 하드디스크에서 삭제  경로 찾아갔을 때 지워지면 true
//		boolean result= fileManager.fileDelete(productFilesVO.getFileName(), "/resources/upload/product/");
		
		// DB에서 삭제 true라면 DB에서도 삭제
//		if (result) {
//			productMapper.setFileDelete(productFilesVO);
//		}
		
		int check=productMapper.setFileDelete(productFilesVO);
		if(check>0) {
			boolean result = fileManager.fileDelete(productFilesVO.getFileName(), "/resources/upload/product/");
			
		}
		
		return check;
	}
	
	public ProductVO getDetail(ProductVO productVO) throws Exception{
		return productMapper.getDetail(productVO);
		
	}
	
	
	
	public List<ProductVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(productMapper.getTotalCount(pager));
		
		return productMapper.getList(pager);
	}

	public int setAdd(ProductVO productVO, MultipartFile[] files) throws Exception {
		
		int result = productMapper.setAdd(productVO);
		
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
				result=productMapper.setFileAdd(productFilesVO);

			}
		}
		return result;
	}
}
