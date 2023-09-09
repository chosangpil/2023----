package com.gg.CompanyDetail;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComDetailServiceImpl implements ComDetailService {
	@Autowired
	ComDetailDAO dao;

	@Autowired
	SqlSessionTemplate session;

	@Override
	public ComDetailDTO getComDetail(String CO_ID) {
		return dao.getComDetail(session, CO_ID);
	}
}
