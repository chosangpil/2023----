package com.gg.Login;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public interface LoginDAO{
	public abstract List<LoginDTO> userList(SqlSessionTemplate session, int user_code);
}
