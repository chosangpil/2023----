package com.gg.modifyPost;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class modifyDAOImpl implements modifyDAO {
    @Override
    public void modifyPos(modifyDTO dto, SqlSessionTemplate session) {
        session.update("UserMapper.modifyPos", dto);
    }
}
