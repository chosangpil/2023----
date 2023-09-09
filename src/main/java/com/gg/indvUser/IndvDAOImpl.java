package com.gg.indvUser;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IndvDAOImpl implements IndvDAO{
	
	@Override
	public void insertIndv(IndvDTO dto, SqlSessionTemplate session) {
		session.insert("UserMapper.insertIndv", dto);
	}
	
	@Override
	public IndvDTO getIndv(SqlSessionTemplate session, String userID) {
		return session.selectOne("UserMapper.getIndv", userID);
	}
}
