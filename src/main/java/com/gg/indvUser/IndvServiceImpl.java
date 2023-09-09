package com.gg.indvUser;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndvServiceImpl implements IndvService{
	@Autowired
	IndvDAO dao;
	
	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public void insertIndv(IndvDTO dto) {
		System.out.println("===========================");
		System.out.println("    Indv ServiceImpl..");
		System.out.println("===========================");
		dao.insertIndv(dto, session);
	}
	
	@Override
	public IndvDTO getIndv(String userID) {
		return dao.getIndv(session, userID);
	}
}
