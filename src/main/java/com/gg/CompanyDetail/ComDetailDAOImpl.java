package com.gg.CompanyDetail;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ComDetailDAOImpl implements ComDetailDAO {
	@Override
	public ComDetailDTO getComDetail(SqlSessionTemplate session, String CO_ID) {
		return session.selectOne("UserMapper.getComDetail", CO_ID);
	}
}
