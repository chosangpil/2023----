package com.gg.Login;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@Override
	public List<LoginDTO> userList(SqlSessionTemplate session, int user_code) {

		if (user_code == 0) {
			return session.selectList("UserMapper.loginIndv");
		} else if (user_code == 1) {
			return session.selectList("UserMapper.loginComp");
		} else if (user_code == 2) {
			return session.selectList("UserMapper.Manager");
		} else {
			return null;
		}
	}
}
