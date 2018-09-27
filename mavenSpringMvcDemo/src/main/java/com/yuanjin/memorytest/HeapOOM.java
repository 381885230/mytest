package com.yuanjin.memorytest;

import java.util.ArrayList;
import java.util.List;

/** 
 * Vm args:-Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError 
 * �ѵ���Сֵ����-Xms���ѵ����ֵ����-Xmx 
 * -XX:+HeapDumpOnOutOfMemoryError��ʾ��������ڳ����ڴ��쳣ʱDump����ǰ���ڴ��ת������ 
 * -XX:HeapDumpPath:Ϊ�����ļ�λ�� 
 * Java ���ڴ�������ԣ��������java����� p51 
 */  
//-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:/  
public class HeapOOM {  
    static class OOMObject{  
  
    }  
    public static void main(String[] args) {  
        List<OOMObject> list=new ArrayList<OOMObject>();  
        while(true){  
            list.add(new OOMObject());  
        }  
    }  
}  