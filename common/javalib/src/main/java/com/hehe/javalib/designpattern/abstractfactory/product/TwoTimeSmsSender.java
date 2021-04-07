package com.hehe.javalib.designpattern.abstractfactory.product;

public class TwoTimeSmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("send TwoTime!");
		System.out.println("send TwoTime!");
	}

}
