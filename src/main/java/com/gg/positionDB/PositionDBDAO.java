package com.gg.positionDB;

import org.mybatis.spring.SqlSessionTemplate;

public interface PositionDBDAO {
	public abstract void insertPos(PositionDBDTO dto, SqlSessionTemplate session);
}