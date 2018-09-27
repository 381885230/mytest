package com.learn.singleton;
public class LHanDanli {
    //����һ��˽�����������ŵ�����˽�е�Ŀ����ָ�ⲿ�޷�ֱ�ӻ�ȡ�����������Ҫʹ���ṩ�Ĺ�����������ȡ
    private static LHanDanli dl = null;
    //����˽�й���������ʾֻ�����ڲ�ʹ�ã���ָ������ʵ��ֻ���ڵ������ڲ�����
    private LHanDanli(){}
    //����һ�������Ĺ����ķ��������ظ����ʵ��������������ʽ����Ҫ�ڵ�һ��ʹ��ʱ����ʵ��������Ϊ���̰߳�ȫ��ʹ��synchronized�ؼ�����ȷ��ֻ�����ɵ���
    public static synchronized LHanDanli getInstance(){
        if(dl == null){
            dl = new LHanDanli();
        }
        return dl;
    }
}