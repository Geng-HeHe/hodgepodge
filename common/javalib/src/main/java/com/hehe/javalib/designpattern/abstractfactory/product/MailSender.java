package com.hehe.javalib.designpattern.abstractfactory.product;

public class MailSender implements Sender {
	@Override
	public void send() {
		System.out.println("this is mail sender!");
	}
}
