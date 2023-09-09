package com.gg.positionDB;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionDBServiceImpl implements PositionDBService {
	@Autowired
	PositionDBDAO dao;

	@Autowired
	SqlSessionTemplate session;

	@Override
	public void insertPos(PositionDBDTO dto) {
		System.out.println("===========================");
		System.out.println("    Pos ServiceImpl..");
		System.out.println("===========================");
		dao.insertPos(dto, session);
	}
}
