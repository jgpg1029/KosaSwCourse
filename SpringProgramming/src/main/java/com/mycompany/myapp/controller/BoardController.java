package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.dto.Board;
import com.mycompany.myapp.service.BoardService;

@Controller
public class BoardController {
   
   private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

   @Autowired
   private BoardService boardService;
   
   @RequestMapping("/board/list")
   public String list(HttpServletRequest request){
      logger.info("list()");
      List<Board> list=boardService.getPage(1, 10);
      
      request.setAttribute("list", list);
      
      return "board/list";
      
      
   }
   
   @RequestMapping("/board/writeForm")
   public String writeForm(){
      logger.info("writeForm()");
      return "board/writeForm";
   }
   
   @RequestMapping("/board/updateForm")
   public String updateForm(){
      logger.info("updateForm()");
      return "board/updateForm";
   }
   
   @RequestMapping("/board/write")
   public String write(String title, String writer, String content){
	   logger.info("wirter()");
	   Board board=new Board();
	   board.setTitle(title);
	   board.setWriter(writer);
	   board.setContent(content);
	   logger.info("title:"+title);
	   logger.info("writer:"+writer);
	   logger.info("content:"+content);
	   boardService.add(board);
	   return "redirect:/board/list";//재 요청
   }
   @RequestMapping("/board/update")
   public String update(){
	   logger.info("update()");
	   return "redirect:/board/list";
   }
}