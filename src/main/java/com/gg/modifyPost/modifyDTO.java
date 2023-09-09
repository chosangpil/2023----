package com.gg.modifyPost;

import org.apache.ibatis.type.Alias;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("modify")
@Getter
@Setter
@ToString

public class modifyDTO {
    String POSITION;
    int POST_NO;/* 8-03 슈ㅜ정 */
    String QUALIFY;
    String EMPLOY_TYPE;
    String JOB;
    Date REGI_DT;

    public modifyDTO() {
    }

    public modifyDTO(String POSITION,
            int POST_NO, String QUALIFY, String EMPLOY_TYPE,
            String JOB, Date REGI_DT) {
        super();
        this.POSITION = POSITION;
        this.POST_NO = POST_NO;/* 8-03 슈ㅜ정 */
        this.QUALIFY = QUALIFY;
        this.EMPLOY_TYPE = EMPLOY_TYPE;
        this.JOB = JOB;
        this.REGI_DT = REGI_DT;
    }
}