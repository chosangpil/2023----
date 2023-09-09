package com.gg.positionDB;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PositionDBDAOImpl implements PositionDBDAO {
	@Override
	public void insertPos(PositionDBDTO dto, SqlSessionTemplate session) {
		session.insert("UserMapper.insertPos", dto);
	}
}
