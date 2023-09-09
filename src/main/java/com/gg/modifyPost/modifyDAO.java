package com.gg.modifyPost;

import org.mybatis.spring.SqlSessionTemplate;

public interface modifyDAO {
    public abstract void modifyPos(modifyDTO dto, SqlSessionTemplate session);
}
