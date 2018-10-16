package com.learn.string.gctest;

/**

 * @Described：逃逸分析测试用例

 * @author YHJ create at 2011-12-24 下午05:07:05

 * @FileNmae com.yhj.jvm.gc.pojo.TestCaseForEscape.java

 */

public class FinalizedEscapeTestCase {

 

    public static FinalizedEscapeTestCase caseForEscape = null;

    @Override

    protected void finalize() throws Throwable {

       super.finalize();

       System.out.println("哈哈，我已逃逸！");

       caseForEscape = this;

    }

}