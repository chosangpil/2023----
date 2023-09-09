package com.gg.jobPosting;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAOImpl implements PostDAO {
	@Override
	public List<PostDTO> postList(SqlSessionTemplate session) {
		return session.selectList("UserMapper.postList");
	}

	@Override
	public List<PostDTO> compostList(SqlSessionTemplate session, String co_ID) {
		return session.selectList("UserMapper.compostList", co_ID);
	}

}
