package com.keem.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.keem.boot3.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ModelAttribute("product")
	public String getProduct() {
		return "product";
	}
	
	@GetMapping("manage")
	public ModelAndView manage() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("product/manage");
		return mv;
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<ProductVO> ar = productService.getList(pager);
		mv.addObject("list",ar);
		mv.setViewName("product/list");
		return mv;
	}
	@GetMapping("add")
	public ModelAndView setAdd() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/add");
		return mv;
	}
	@GetMapping("ajaxList")
	public ModelAndView getAjaxList(Pager pager) throws Exception{
		ModelAndView mv= new ModelAndView();
		System.out.println("ajaxList");
		List<ProductVO> ar = productService.getList(pager);
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("common/productList");
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(ProductVO productVO,MultipartFile [] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		for(MultipartFile f:files) {
			System.out.println(f.getOriginalFilename());
			System.out.println(f.getSize());
		}
		int result = productService.setAdd(productVO, files);
		mv.setViewName("common/result");
		mv.addObject("result",result);
		return mv;
	}
	
	
}
