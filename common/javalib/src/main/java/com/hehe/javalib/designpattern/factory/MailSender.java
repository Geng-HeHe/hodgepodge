package com.hehe.javalib.designpattern.factory;

public class MailSender implements Sender {
	@Override
	public void Send() {
		System.out.println("this is mail sender!");
	}
}
