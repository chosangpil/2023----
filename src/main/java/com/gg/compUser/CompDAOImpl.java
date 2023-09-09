package com.gg.compUser;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CompDAOImpl implements CompDAO {
	@Override
	public void insertComp(CompDTO dto, SqlSessionTemplate session) {
		session.insert("UserMapper.insertComp", dto);
	}

	@Override
	public CompDTO getComp(SqlSessionTemplate session, String userID) {
		return session.selectOne("UserMapper.getComp", userID);
	}
}
