package com.learn.string.gctest;

/**

 * @Described�����ݷ�����������

 * @author YHJ create at 2011-12-24 ����05:07:05

 * @FileNmae com.yhj.jvm.gc.pojo.TestCaseForEscape.java

 */

public class FinalizedEscapeTestCase {

 

    public static FinalizedEscapeTestCase caseForEscape = null;

    @Override

    protected void finalize() throws Throwable {

       super.finalize();

       System.out.println("�������������ݣ�");

       caseForEscape = this;

    }

}