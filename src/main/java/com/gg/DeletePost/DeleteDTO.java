package com.gg.DeletePost;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("delete")
@Getter
@Setter
@ToString

public class DeleteDTO {
    int POST_NO;/* 8-03 슈ㅜ정 */

    public DeleteDTO() {
    }

    public DeleteDTO(int POST_NO) {
        super();
        this.POST_NO = POST_NO;/* 8-03 슈ㅜ정 */
    }
}
