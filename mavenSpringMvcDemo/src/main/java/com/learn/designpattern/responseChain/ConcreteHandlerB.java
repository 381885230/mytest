package com.learn.designpattern.responseChain;
public class ConcreteHandlerB extends Handler {

    public void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println(this.getClass() + "  处理请求  " + request);
        }else if (successor != null) {
            successor.handleRequest(request);
        }
    }

}
