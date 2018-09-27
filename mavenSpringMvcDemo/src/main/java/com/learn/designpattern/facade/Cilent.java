package com.learn.designpattern.facade;

import org.apache.log4j.Logger;

/**
 * øÕªß∂À¿‡
 * @author Administrator
 *
 */
public class Cilent {
    public static final Logger LOGGER = Logger.getLogger(Cilent.class);
    public static void main(String[] args) 
    {
        Computer computer = new Computer();
        computer.start();
        LOGGER.info("=================");
        computer.shutDown();
    }

}