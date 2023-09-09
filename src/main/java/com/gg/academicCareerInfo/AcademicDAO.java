package com.gg.academicCareerInfo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public interface AcademicDAO {
	public abstract void insertAcademic(AcademicDTO listDTO, SqlSessionTemplate session);

	public abstract List<AcademicDTO> academicList(SqlSessionTemplate session, String userID);
}
