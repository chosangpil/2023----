package com.gg.careerInfo;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("careerinfo")
@Getter
@Setter
@ToString
public class CareerDTO {
	int ID;
	String P_ID;
	String P_COMPANY;
	String P_DEPARTMENT;
	String P_DUTY;
	
	public CareerDTO() {}

	public CareerDTO(int ID, String P_ID, String P_COMPANY, String P_DEPARTMENT, String P_DUTY) {
		super();
		this.ID = ID;
		this.P_ID = P_ID;
		this.P_COMPANY = P_COMPANY;
		this.P_DEPARTMENT = P_DEPARTMENT;
		this.P_DUTY = P_DUTY;
	}
}