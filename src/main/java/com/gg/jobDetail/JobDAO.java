package com.gg.jobDetail;

import org.mybatis.spring.SqlSessionTemplate;

public interface JobDAO {
    public abstract JobDTO getJobDetail(SqlSessionTemplate session, int POST_NO);
}