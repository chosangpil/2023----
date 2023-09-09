package com.gg.Login;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("user")
@Getter
@Setter
@ToString
public class LoginDTO {
	String ID;
	String PW;
	int user_code;
	
	public LoginDTO() {}

	public LoginDTO(String ID, String PW, int user_code) {
		super();
		this.ID = ID;
		this.PW = PW;
		this.user_code = user_code;
	}
}
