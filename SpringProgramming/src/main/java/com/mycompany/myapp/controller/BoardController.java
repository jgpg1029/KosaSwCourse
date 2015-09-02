package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
   
   private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

   @RequestMapping("board/list")
   public String list(){
      logger.info("list()");
      return "board/list";
   }
   
   @RequestMapping("board/writeForm")
   public String writeForm(){
      logger.info("writeForm()");
      return "board/writeForm";
   }
   
   @RequestMapping("board/updateForm")
   public String updateForm(){
      logger.info("updateForm()");
      return "board/updateForm";
   }
}