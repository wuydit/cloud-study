package com.wuyd.cloudproviderpayment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wuYd
 * 2020/9/17 16:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public CommonResult(Integer code, String msg){
        this(code, msg, null);
    }
}
