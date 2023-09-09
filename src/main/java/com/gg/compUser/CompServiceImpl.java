package com.gg.compUser;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompServiceImpl implements CompService {
	@Autowired
	CompDAO dao;
	
	@Autowired
	SqlSessionTemplate session;

	@Override
	public void insertComp(CompDTO dto) {
		System.out.println("===========================");
		System.out.println("    Comp ServiceImpl..");
		System.out.println("===========================");
		dao.insertComp(dto, session);
	}
	
	@Override
	public CompDTO getComp(String userID) {
		return dao.getComp(session, userID);
	}
}
