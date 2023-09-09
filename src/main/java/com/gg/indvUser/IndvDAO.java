package com.gg.indvUser;

import org.mybatis.spring.SqlSessionTemplate;

public interface IndvDAO {
	public abstract void insertIndv(IndvDTO dto, SqlSessionTemplate session);
	public abstract IndvDTO getIndv(SqlSessionTemplate session, String userID);
}
