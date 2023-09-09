package com.gg.jobPosting;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDAO dao;

	@Autowired
	SqlSessionTemplate session;

	@Override
	public List<PostDTO> postList() {
		System.out.println("===========================");
		System.out.println("    Post ServiceImpl..");
		System.out.println("===========================");
		return dao.postList(session);
	}

	public List<PostDTO> compostList(String co_ID) {
		System.out.println("===========================");
		System.out.println("    Post ServiceImpl..");
		System.out.println("===========================");
		return dao.compostList(session, co_ID);
	}
}
