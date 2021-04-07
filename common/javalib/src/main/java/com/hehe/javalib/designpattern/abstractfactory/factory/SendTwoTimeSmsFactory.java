package com.hehe.javalib.designpattern.abstractfactory.factory;


import com.hehe.javalib.designpattern.abstractfactory.product.Sender;
import com.hehe.javalib.designpattern.abstractfactory.product.TwoTimeSmsSender;

/**
 * 生产发送两次的Sender工厂
 */
public class SendTwoTimeSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new TwoTimeSmsSender();
	}

}
