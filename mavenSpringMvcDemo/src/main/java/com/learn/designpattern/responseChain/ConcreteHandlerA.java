package com.learn.designpattern.responseChain;
public class ConcreteHandlerA extends Handler {

    public void handleRequest(int request) {
        if (request >= 0 && request < 10) {
            System.out.println(this.getClass() + "  处理请求  " + request);
        }else if (successor != null) {
            successor.handleRequest(request);
        }
    }

}
