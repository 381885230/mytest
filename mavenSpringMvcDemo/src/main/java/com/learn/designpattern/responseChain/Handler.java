package com.learn.designpattern.responseChain;

public abstract class Handler {

    protected Handler successor;//继任者

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    //处理请求
    public void handleRequest(int request) {}


}
