package com.dgit.persistance;

import java.sql.SQLException;
import java.util.List;

import com.dgit.domain.ManagerVO;

public interface ManagerDAO {
	public List<ManagerVO> selectByAll() throws SQLException;
	public void insert(ManagerVO vo) throws SQLException;
	public ManagerVO selectById(int number) throws SQLException;
	public void update(ManagerVO vo) throws SQLException;
	public void delete(int num) throws SQLException;
}
