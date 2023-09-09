package com.gg.jobPosting;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public interface PostDAO {
    public abstract List<PostDTO> postList(SqlSessionTemplate session);

    public abstract List<PostDTO> compostList(SqlSessionTemplate session, String co_ID);
}
