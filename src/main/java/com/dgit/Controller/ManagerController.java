package com.dgit.Controller;

import java.sql.SQLException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public void selectById(Model model ,int number) throws SQLException{
		logger.info("readProject Start..............................");
		ManagerVO vo = service.selectById(number);
		model.addAttribute("project", vo);
	}
	
	@RequestMapping(value="/projectWrite",method=RequestMethod.GET)
	public void insertGet(){
		logger.info("insert Start..............................");
		
	}
	
	@RequestMapping(value="/projectWrite",method=RequestMethod.POST)
	public String insert(ManagerVO vo) throws SQLException{
		logger.info("insert Post..............................");
		service.insert(vo);
		return "redirect:/manager/projectList";
	}
	
	@RequestMapping(value="/projectModify",method=RequestMethod.GET)
	public String update(int number,Model model) throws SQLException{
		logger.info("update Start..............................");
		ManagerVO vo = service.selectById(number);
		model.addAttribute("project", vo);
		return "manager/projectModify";
	}
	
	@RequestMapping(value="/projectModify",method=RequestMethod.POST)
	public String updatePost(ManagerVO vo) throws SQLException{
		logger.info("update Start Post..............................");
		service.update(vo);
		return "redirect:/manager/projectModify?number="+vo.getNumber();
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(int number) throws SQLException{
		logger.info("number : " + number);
		service.delete(number);
		return "redirect:/manager/projectList";
	}
}
