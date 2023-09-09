package com.gg.DeletePost;

import org.mybatis.spring.SqlSessionTemplate;

public interface DeleteDAO {
    public abstract void DeletePos(DeleteDTO dto, SqlSessionTemplate session);
}
