package com.gg.careerInfo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CareerDAOImpl implements CareerDAO {

	@Override
	public void insertCareer(CareerDTO dto, SqlSessionTemplate session) {
		session.insert("UserMapper.insertCareer", dto);
	}

	@Override
	public List<CareerDTO> careerList(SqlSessionTemplate session, String userID){
		return session.selectList("UserMapper.getIndvCI", userID);
	}
}
