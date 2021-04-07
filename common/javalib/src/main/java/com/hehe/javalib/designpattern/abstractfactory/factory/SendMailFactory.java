package com.hehe.javalib.designpattern.abstractfactory.factory;


import com.hehe.javalib.designpattern.abstractfactory.product.MailSender;
import com.hehe.javalib.designpattern.abstractfactory.product.Sender;

/**
 * 生产发送邮件的工厂
 */
public class SendMailFactory implements Provider {

	@Override
	public Sender produce(){
		return new MailSender();
	}
}
