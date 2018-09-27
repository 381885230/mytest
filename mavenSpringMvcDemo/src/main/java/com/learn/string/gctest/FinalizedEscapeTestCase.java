package com.learn.string.gctest;

/**

 * @Described£ºÌÓÒİ·ÖÎö²âÊÔÓÃÀı

 * @author YHJ create at 2011-12-24 ÏÂÎç05:07:05

 * @FileNmae com.yhj.jvm.gc.pojo.TestCaseForEscape.java

 */

public class FinalizedEscapeTestCase {

 

    public static FinalizedEscapeTestCase caseForEscape = null;

    @Override

    protected void finalize() throws Throwable {

       super.finalize();

       System.out.println("¹ş¹ş£¬ÎÒÒÑÌÓÒİ£¡");

       caseForEscape = this;

    }

}