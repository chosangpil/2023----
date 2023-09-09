package com.gg.positionDB;

import org.apache.ibatis.type.Alias;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("position")
@Getter
@Setter
@ToString
public class PositionDBDTO {
	String POSITION;
	int POST_NO;/* 8-03 슈ㅜ정 */
	String QUALIFY;
	String EMPLOY_TYPE;
	String JOB;
	String CO_ID;/* 8-03 슈ㅜ정 */
	Date REGI_DT;
	int CO_NO;
	String CO_EMAIL;

	public PositionDBDTO() {
	}

	public PositionDBDTO(String POSITION,
			int POST_NO, String QUALIFY, String EMPLOY_TYPE,
			String JOB, Date REGI_DT, int CO_NO, String CO_ID) {
		super();
		this.POSITION = POSITION;
		this.POST_NO = POST_NO;/* 8-03 슈ㅜ정 */
		this.QUALIFY = QUALIFY;
		this.EMPLOY_TYPE = EMPLOY_TYPE;
		this.JOB = JOB;
		this.REGI_DT = REGI_DT;
		this.CO_NO = CO_NO;
		this.CO_ID = CO_ID;/* 8-03 슈ㅜ정 */
	}
}
