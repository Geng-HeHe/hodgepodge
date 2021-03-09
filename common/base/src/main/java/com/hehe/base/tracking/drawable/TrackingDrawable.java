package com.hehe.base.tracking.drawable;


import com.hehe.hrouter.api.core.Call;

/**
 * 订单模块对外暴露接口，其他模块可以获取返回res资源
 */
public interface TrackingDrawable extends Call {

    int getDrawable();
}
