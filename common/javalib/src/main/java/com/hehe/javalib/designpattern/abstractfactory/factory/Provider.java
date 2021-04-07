package com.hehe.javalib.designpattern.abstractfactory.factory;


import com.hehe.javalib.designpattern.abstractfactory.product.Sender;

/**
 * 抽象工厂的生产接口，生产消息发送者Sender
 */
public interface Provider {

	Sender produce();
}
