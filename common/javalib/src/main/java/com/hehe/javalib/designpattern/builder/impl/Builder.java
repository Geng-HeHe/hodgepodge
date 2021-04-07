package com.hehe.javalib.designpattern.builder.impl;

/**
 * 构建者的实现接口
 */
public interface Builder {

	<T extends Builder> T setUrl(String url);

	<T extends Builder> T setHead(String head);

	<T extends Builder> T setMode(String mode);

	<T extends Builder> T setBody(String body);

	<T extends Builder> T setParam(String param);

	RequestBody build();
}
