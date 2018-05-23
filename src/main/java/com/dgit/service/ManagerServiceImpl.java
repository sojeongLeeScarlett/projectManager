package com.dgit.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.ManagerVO;
import com.dgit.persistance.ManagerDAO;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	ManagerDAO dao;
	
	
	@Override
	public List<ManagerVO> selectByAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.selectByAll();
	}
	
	@Override
	public void insert(ManagerVO vo) throws SQLException {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}
	
	@Override
	public ManagerVO selectById(int number) throws SQLException {
		// TODO Auto-generated method stub
		return dao.selectById(number);
	}

	@Override
	public void update(ManagerVO vo) throws SQLException {
		// TODO Auto-generated method stub
		dao.update(vo);
	}
	
	@Override
	public void delete(int num) throws SQLException {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

}
