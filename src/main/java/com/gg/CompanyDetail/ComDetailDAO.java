package com.gg.CompanyDetail;

import org.mybatis.spring.SqlSessionTemplate;

public interface ComDetailDAO {
    public abstract ComDetailDTO getComDetail(SqlSessionTemplate session, String userID);
}