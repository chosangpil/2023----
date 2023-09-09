package com.gg.jobDetail;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JobDAOImpl implements JobDAO {
    @Override
    public JobDTO getJobDetail(SqlSessionTemplate session, int post_NO) {
        return session.selectOne("UserMapper.getDetail", post_NO);
    }
}
