package com.learn.designpattern.responseChain;
public class ConcreteHandlerC extends Handler {

    public void handleRequest(int request) {
        if (request >= 20 && request < 30) {
            System.out.println(this.getClass() + "  处理请求  " + request);
        }else if (successor != null) {
            successor.handleRequest(request);
        }
    }

}
