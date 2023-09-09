package com.gg.jobDetail;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("jobdetail")
@Getter
@Setter
@ToString
public class JobDTO {
    String POSITION;
    int POST_NO;/* 8-03 슈ㅜ정 */
    String QUALIFY;
    String EMPLOY_TYPE;
    String JOB;
    String CO_ID;/* 8-03 슈ㅜ정 */
    String REGI_DT;
    int CO_NO;

    public JobDTO() {
    }

    public JobDTO(String POSITION,
            int POST_NO, String QUALIFY, String EMPLOY_TYPE,
            String JOB, String REGI_DT, int CO_NO, String CO_ID) {
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