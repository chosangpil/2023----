package com.gg.academicCareerInfo;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("academiccareerinfo")
@Getter
@Setter
@ToString
public class AcademicDTO {
	int ID;
	String P_ID;
	String DEGREE;
	String SCHOOL_NAME;
	String MAJOR;
	int ADMISSION_DATE;
	int GRADUATION_DATE;

	public AcademicDTO() {
	}

	public AcademicDTO(int ID, String P_ID, String DEGREE, String SCHOOL_NAME, String MAJOR, int ADMISSION_DATE,
			int GRADUATION_DATE) {
		super();
		this.ID = ID;
		this.P_ID = P_ID;
		this.DEGREE = DEGREE;
		this.SCHOOL_NAME = SCHOOL_NAME;
		this.MAJOR = MAJOR;
		this.ADMISSION_DATE = ADMISSION_DATE;
		this.GRADUATION_DATE = GRADUATION_DATE;
	}
}
