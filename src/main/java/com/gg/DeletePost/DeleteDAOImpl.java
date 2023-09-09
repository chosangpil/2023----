package com.gg.DeletePost;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteDAOImpl implements DeleteDAO {
    @Override
    public void DeletePos(DeleteDTO dto, SqlSessionTemplate session) {
        session.delete("UserMapper.DeletePos", dto);
    }
}
