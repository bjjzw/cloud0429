package com.dascom.main.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by jiazw on 4/29/2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    private int code;

    private String message;

    private List<T> data;

}
