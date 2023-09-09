package com.gg.compList;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CompListServiceImpl implements CompListService {
	@Autowired
	CompListDAO dao;

	@Autowired
	SqlSessionTemplate session;

	@Override
	public List<CompListDTO> compList() {
		System.out.println("===========================");
		System.out.println("  Comp List ServiceImpl..");
		System.out.println("===========================");
		return dao.compList(session);
	}

	@Override
	public int compNo(@RequestParam("co_id") String co_id) {
		System.out.println("===========================");
		System.out.println("  Comp No ServiceImpl..");
		System.out.println("===========================");
		if (co_id != null)
			return dao.compNo(session, co_id).getCO_NO();
		else
			return -1;
	}
}
