package com.github.seata.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author dengmin
 * @Created 2020/4/24 16:03
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Object data;
    private int code;

    public static Result ok(Object data){
        return new Result(data, 200);
    }


}
