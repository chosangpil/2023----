package com.gg.jobDetail;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class JobServiceImpl implements JobService {

    @Autowired
    JobDAO dao;

    @Autowired
    SqlSessionTemplate session;

    @Override
    public JobDTO getJobDetail(int post_NO) {
        return dao.getJobDetail(session, post_NO);
    }

}