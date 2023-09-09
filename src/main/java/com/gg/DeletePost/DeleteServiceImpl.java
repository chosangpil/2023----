package com.gg.DeletePost;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteServiceImpl implements DeleteService {
	@Autowired
	DeleteDAO dao;

	@Autowired
	SqlSessionTemplate session;

	@Override
	public void DeletePos(DeleteDTO dto) {
		System.out.println("===========================");
		System.out.println("    Pos ServiceImpl..");
		System.out.println("===========================");
		dao.DeletePos(dto, session);
	}
}