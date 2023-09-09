package com.gg.compUser;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("compuser")
@Getter
@Setter
@ToString
public class CompDTO {
	int CO_NO;
	String CO_ID;
	String CO_PW;
	String COMPANY;
	String HR;
	String CO_EMAIL;
	String CO_NUMBER;
	String CATEGORY_ID;
	String SIZE_ID;	
	
	public CompDTO() {}

	public CompDTO(int CO_NO, String CO_ID, String CO_PW,
		String COMPANY, String HR, String CO_EMAIL, String CO_NUMBER,
		String CATEGORY_ID, String SIZE_ID) {
		super();
		this.CO_NO = CO_NO;
		this.CO_ID = CO_ID;
		this.CO_PW = CO_PW;
		this.COMPANY = COMPANY;
		this.HR = HR;
		this.CO_EMAIL = CO_EMAIL;
		this.CO_NUMBER = CO_NUMBER;
		this.CATEGORY_ID = CATEGORY_ID;
		this.SIZE_ID = SIZE_ID;
	}

	public CompDTO(String COMPANY) {
		super();
		this.COMPANY = COMPANY;
	}
}
