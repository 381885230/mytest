package com.learn.singleton;
public class EHanDanli {
    //�˴����������ʵ����ֱ��ʵ������������ص�ʱ��������ʵ����������������
    private static EHanDanli dl = new EHanDanli();
    //�����޲ι����������ڵ���ʵ��
    private EHanDanli(){}
    //���幫�������������Ѵ����ĵ���
    public static EHanDanli getInstance(){
        return dl;
    }
}