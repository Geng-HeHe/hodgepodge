package com.hehe.javalib.designpattern.abstractfactory.factory;


import com.hehe.javalib.designpattern.abstractfactory.product.Sender;
import com.hehe.javalib.designpattern.abstractfactory.product.SmsSender;

public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}
}
