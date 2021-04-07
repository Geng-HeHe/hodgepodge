package com.hehe.javalib.designpattern.abstractfactory;


import com.hehe.javalib.designpattern.abstractfactory.factory.Provider;
import com.hehe.javalib.designpattern.abstractfactory.factory.SendTwoTimeSmsFactory;
import com.hehe.javalib.designpattern.abstractfactory.product.Sender;

/**
 * 抽象工厂模式，工厂是抽象的，产品是抽象的。
 * 剥离工厂与产品之前的耦合，便于扩展
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        Provider provider = new SendTwoTimeSmsFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
