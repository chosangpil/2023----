package com.gg.academicCareerInfo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AcademicDAOImpl implements AcademicDAO {

	@Override
	public void insertAcademic(AcademicDTO listDTO, SqlSessionTemplate session) {
		session.insert("UserMapper.insertAcademic", listDTO);
	}

	@Override
	public List<AcademicDTO> academicList(SqlSessionTemplate session, String userID) {
		return session.selectList("UserMapper.getIndvACI", userID);
	}
}
