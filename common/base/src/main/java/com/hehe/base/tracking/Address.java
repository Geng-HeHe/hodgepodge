package com.hehe.base.tracking;


import com.hehe.hrouter.api.core.Call;

import java.io.IOException;

/**
 * 订单模块对外暴露接口，其他模块可以获取返回业务数据
 */
public interface Address extends Call {

    AddressrBean getBean(String key, String ip) throws IOException;
}
