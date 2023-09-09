package com.gg.compList;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("companylist")
@Getter
@Setter
@ToString
public class CompListDTO {
	int CO_NO;
	String CO_ID;
	String COMPANY;
	String HR;
	String CO_EMAIL;
	String CATEGORY_ID;/* 수정7-22 CO_CATEGORY ->CATEGORY_ID */
	String SIZE_ID; /* 수정7-22 CO_SIZE -> SIZE_ID */

	public CompListDTO() {
	}

	public CompListDTO(int CO_NO, String CO_ID, String COMPANY, String HR, String CO_EMAIL, String CATEGORY_ID,
			String SIZE_ID) {
		super();
		this.CO_ID = CO_ID;
		this.CO_NO = CO_NO;
		this.COMPANY = COMPANY;
		this.HR = HR;
		this.CO_EMAIL = CO_EMAIL;
		this.CATEGORY_ID = CATEGORY_ID;/* 수정7-22 CO_CATEGORY ->CATEGORY_ID */
		this.SIZE_ID = SIZE_ID; /* 수정7-22 CO_SIZE -> SIZE_ID */
	}

	public CompListDTO(String COMPANY) {
		super();
		this.COMPANY = COMPANY;
	}
}
