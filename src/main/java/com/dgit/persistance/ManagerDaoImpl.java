package com.dgit.persistance;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.ManagerVO;

@Repository
public class ManagerDaoImpl implements ManagerDAO {
	@Autowired
	SqlSession session;
	
	private static final String namespace = "com.dgit.mapper.ManagerMapper";


	@Override
	public List<ManagerVO> selectByAll() throws SQLException {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectByAll");
	}

	@Override
	public void insert(ManagerVO vo) throws SQLException {
		// TODO Auto-generated method stub
		session.insert(namespace+".insert", vo);
	}

	@Override
	public ManagerVO selectById(int number) throws SQLException {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectById", number);
	}

	@Override
	public void update(ManagerVO vo) throws SQLException {
		// TODO Auto-generated method stub
		 session.update(namespace+".update", vo);
	}

	@Override
	public void delete(int num) throws SQLException {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete", num);
	}

}
