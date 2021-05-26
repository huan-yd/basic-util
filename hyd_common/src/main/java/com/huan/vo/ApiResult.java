package com.huan.vo;

import com.huan.constants.ReturnCodeConstants;
import com.huan.enums.MsgCommonEnum;
import com.huan.utils.MsgUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 统一响应信息主体
 */
@Data
public class ApiResult<T> implements Serializable {

    private T data;

    private Integer code = ReturnCodeConstants.SUCCESS;

    private String msg = "success";

    private ApiResult() {
    }

    /**
     * 有时候前端只需要知道，我执行成功了
     *
     * @return
     */
    public static <T> ApiResult<T> ok() {
        return new ApiResult<T>();
    }

    public static <T> ApiResult<T> ok(T data) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setData(data);
        return apiResult;
    }

    public static ApiResult error(MsgCommonEnum msgCommonEnum, String... args) {
        ApiResult apiResult = new ApiResult();
        apiResult.setMsg(MsgUtil.createMsg(msgCommonEnum, args));
        apiResult.setCode(ReturnCodeConstants.E_SYSTEM_ERROR);
        return apiResult;
    }

}
