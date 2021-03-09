package com.hehe.modular.tracking.impl;


import com.hehe.base.tracking.drawable.TrackingDrawable;
import com.hehe.hrouter.annotation.HRouter;
import com.hehe.modular.tracking.R;

/**
 * 订单模块对外暴露接口实现类，其他模块可以获取返回res资源
 */
@HRouter(path = "/tracking/getDrawable")
public class TrackingDrawableImpl implements TrackingDrawable {

    @Override
    public int getDrawable() {
        return R.drawable.ic_ac_unit_black_24dp;
    }
}
