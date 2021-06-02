package com.huan.sms.service;



import com.huan.dto.SysParamsDTO;

import java.util.List;
import java.util.Map;

/**
 * 参数管理
 */
public interface SysParamsService {



    /**
     * 根据参数编码，获取value的Object对象
     *
     * @param paramCode 参数编码
     * @param clazz     Object对象
     */
    <T> T getValueObject(String paramCode, Class<T> clazz);


}
