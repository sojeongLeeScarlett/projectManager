package com.dgit.Controller;

import java.sql.SQLException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dgit.domain.ManagerVO;
import com.dgit.service.ManagerService;

@Controller
@RequestMapping("/manager/*")
public class ManagerController {
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	@Autowired
	ManagerService service;
		
	@RequestMapping(value="/projectList",method=RequestMethod.GET)
	public void selectByAll(Model model) throws Exception{
		logger.info("selectByAll Start..............................");
		List<ManagerVO> list = service.selectByAll();
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value="/projectRead",method=RequestMethod.GET)
	public String selectById(Model model ,int number) throws SQLException{
		logger.info("readProject Start..............................");
		ManagerVO vo = service.selectById(number);
		model.addAttribute("project", vo);
		return "/manager/projectRead";
	}
	
	@RequestMapping(value="/projectWrite",method=RequestMethod.GET)
	public void insertGet(){
		logger.info("insert Start..............................");
		
	}
	
	@ResponseBody
	@RequestMapping(value="/projectWrite",method=RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestBody ManagerVO vo) throws SQLException{
		logger.info("insert Post..............................");
		logger.info("시작 : "+vo);
		
		ResponseEntity<String> entity = null;
		try{
			service.insert(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/projectModify",method=RequestMethod.GET)
	public String update(int number,Model model) throws SQLException{
		logger.info("update Start..............................");
		ManagerVO vo = service.selectById(number);
		model.addAttribute("project", vo);
		return "manager/projectModify";
	}
	@ResponseBody
	@RequestMapping(value="/projectModify",method=RequestMethod.POST)
	public ResponseEntity<String> updatePost(@RequestBody ManagerVO vo) throws SQLException{
		logger.info("update Start Post..............................");
		ResponseEntity<String> entity = null;
		try {
			service.update(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(int number) throws SQLException{
		logger.info("number : " + number);
		service.delete(number);
		return "redirect:/manager/projectList";
	}
}
