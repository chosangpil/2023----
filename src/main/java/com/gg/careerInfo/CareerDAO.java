package com.gg.careerInfo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public interface CareerDAO {
	public abstract void insertCareer(CareerDTO dto, SqlSessionTemplate session);
	public abstract List<CareerDTO> careerList(SqlSessionTemplate session, String userID);
}
