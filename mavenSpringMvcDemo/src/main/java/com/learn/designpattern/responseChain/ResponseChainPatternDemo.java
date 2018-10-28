package com.learn.designpattern.responseChain;

public class ResponseChainPatternDemo {

    public static void main(String[] args) {

        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        Handler handlerC = new ConcreteHandlerC();

        //设置责任链的前驱和后继
        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        int[] requests = {2,5,14,22,18,27,20};
        for (int request : requests) {
            handlerA.handleRequest(request);
        }

    }

}
