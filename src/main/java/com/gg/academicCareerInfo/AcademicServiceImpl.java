package com.gg.academicCareerInfo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicServiceImpl implements AcademicService {
	@Autowired
	AcademicDAO dao;
	
	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public void insertAcademic(AcademicDTO dto) {
		System.out.println("===========================");
		System.out.println("Academic Career ServiceImpl..");
		System.out.println("===========================");
		dao.insertAcademic(dto, session);
	}

	@Override
	public List<AcademicDTO> academicList(String userID){
		return dao.academicList(session, userID);
	}
}
