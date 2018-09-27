package com.learn.designpattern.facade;

import org.apache.log4j.Logger;

/**
 * Memory��ϵͳ��
 * @author Administrator
 *
 */
public class Memory
{
    public static final Logger LOGGER = Logger.getLogger(Memory.class);
    public void start()
    {
        LOGGER.info("Memory is start...");
    }
    
    public void shutDown()
    {
        LOGGER.info("Memory is shutDown...");
    }
}