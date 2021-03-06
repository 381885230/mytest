package com.learn.string.gctest;

 
/**

 * @Described：逃逸分析测试

 * @author YHJ create at 2011-12-24 下午05:08:09

 * @FileNmae com.yhj.jvm.gc.finalizeEscape.FinalizedEscape.java

 */

public class FinalizedEscape {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(FinalizedEscapeTestCase.caseForEscape);

       FinalizedEscapeTestCase.caseForEscape = new FinalizedEscapeTestCase();

        System.out.println(FinalizedEscapeTestCase.caseForEscape);

       FinalizedEscapeTestCase.caseForEscape=null;

       System.gc();

       Thread.sleep(100);

        System.out.println(FinalizedEscapeTestCase.caseForEscape);

    }

}