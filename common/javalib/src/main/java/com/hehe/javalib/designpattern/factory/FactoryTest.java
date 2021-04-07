package com.hehe.javalib.designpattern.factory;

/**
 * 工厂模式是我们最常用的实例化对象模式了，是用工厂方法代替new操作的一种模式。
 */
public class FactoryTest {

    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.Send();
    }
}
