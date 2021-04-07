package com.hehe.javalib.designpattern.builder;


import com.hehe.javalib.designpattern.builder.impl.RequestBuilder;

/**
 * 建造者模式： 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 * <p>
 * 建造者模式注重零部件的组装过程【具体的创建在产品内部创建】
 */
public class BuilderTest {

    public static void main(String[] args) {
        String result = new RequestBuilder("http://192.168.1.23")
                .setParam("param123")
                .setHead("head123")
                .setMode("post")
                .setBody("请求结果")
                .build()
                .request();

        System.out.print(result);
    }
}
