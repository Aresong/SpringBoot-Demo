package com.s5.starter;

/**
 * @Author: Aresong
 * @Date: 2019/5/22 22:35
 * @Version 1.0
 */
public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    //模拟一个需要配置参数的业务
    public String sayHelloS5(String name){
        return  helloProperties.getPrefix() + name + helloProperties.getSuffix();
    }
}
