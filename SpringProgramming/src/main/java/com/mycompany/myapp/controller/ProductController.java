package com.mycompany.myapp.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.myapp.dto.Board;
import com.mycompany.myapp.dto.Product;
import com.mycompany.myapp.service.ProductService;

@Controller
public class ProductController {
   
   private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

   @Autowired
   private ProductService productService;
   
   @RequestMapping("/product/list")
   public String list(@RequestParam(defaultValue="1") int pageNo, Model model){
      logger.info("list()");
    //페이징을 위한 변수 선언
      int rowsPerPage=10;
      int pagesPerGroup=5;
    //전체 게시물 수
      int totalBoardNo=productService.getTotalBoardNo();
    //전체 페이지 수
    		int totalPageNo=totalBoardNo/rowsPerPage;
    		if(totalBoardNo%rowsPerPage!=0){totalPageNo++;}
    		
    		//전체 그룹 수
    		int totalGroupNo=totalPageNo/pagesPerGroup;
    		if(totalPageNo%pagesPerGroup!=0){totalGroupNo++;}
    		
    		//현재 그룹 번호, 시작페이지 번호, 끝페이지번호
    		int groupNo=(pageNo-1)/pagesPerGroup+1;
    		int startPageNo=(groupNo-1)*pagesPerGroup+1;
    		int endPageNo=startPageNo+pagesPerGroup-1;
    		if(groupNo==totalGroupNo){endPageNo=totalPageNo;}
    		
    		//현재 페이지 게시물 리스트
    		List<Product> list=productService.getPage(pageNo, rowsPerPage);
    		
    		//View로 넘길 데이터
    		model.addAttribute("pagesPerGroup", pagesPerGroup);
    		model.addAttribute("totalPageNo", totalPageNo);
    		model.addAttribute("totalGroupNo", totalGroupNo);
    		model.addAttribute("groupNo", groupNo);
    		model.addAttribute("startPageNo", startPageNo);
    		model.addAttribute("endPageNo", endPageNo);
    		model.addAttribute("pageNo", pageNo);
    		model.addAttribute("list", list);
      
      return "product/list";
      
      
   }
   
   @RequestMapping("/product/writeForm")
   public String writeForm(){
      logger.info("writeForm()");
      return "product/writeForm";
   }
   
   @RequestMapping("/product/updateForm")
   public String updateForm(){
      logger.info("updateForm()");
      return "product/updateForm";
   }
   
   @RequestMapping("/product/write")
   public String write(
			String name,
			int price,
			MultipartFile attach,
			HttpSession session  //parameter 명과 매개변수 명이 일치할 때 값이 들어온다
			){
		//파일 정보 얻기
		
		ServletContext application=session.getServletContext();
		String dirPath=application.getRealPath("/resources/uploadfiles");
		String originalFileName=attach.getOriginalFilename();
		String filesystemName=System.currentTimeMillis()+"-"+originalFileName;
		String contentType=attach.getContentType();
		if(!attach.isEmpty()){
		//파일에 저장하기
				try{
				attach.transferTo(new File(dirPath+"/"+filesystemName));
				}catch(Exception e){e.printStackTrace();}
		}
		//데이터 베이스에 게시물 정보 저장
		Product product=new Product();
		product.setName(name);
		product.setPrice(price);

		if(!attach.isEmpty()){
		product.setOriginalFileName(originalFileName);
		product.setFilesystemName(filesystemName);

		product.setContentType(contentType);
		}
		productService.add(product);
	   return "redirect:/product/list";//재 요청
   }
   @RequestMapping("/product/update")
   public String update(){
	   logger.info("update()");
	   return "redirect:/product/list";
   }
   
   @RequestMapping("/product/detail")
	public String detail(int productNo, Model model){
		Product product=productService.getBoard(productNo);
		model.addAttribute("product", product);
		
		return "product/detail";
		
	}
}