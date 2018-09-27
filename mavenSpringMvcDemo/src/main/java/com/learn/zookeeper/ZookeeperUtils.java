package com.learn.zookeeper;
 
import java.io.IOException;
 
import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
 
/**
 * Zookeeper  
 */
public class ZookeeperUtils{
	
	private	Logger logger = Logger.getLogger(this.getClass());
	//����һ��watcher����,�����Ƕ�Zookeeper�����޸ĵ�ʱ�򶼻ᴥ�����¼�
	private Watcher watcher = new Watcher() {
		@Override
		public void process(WatchedEvent event) {
			logger.debug("--------ZK Watcher---------");
		}
	};
	
	//��ʼ��Zookeeper
	private ZooKeeper zooKeeper ;
	
	public void zookeeperInit() throws IOException {
		//���ipʹ�ã��ŷָ�
//		zooKeeper = new ZooKeeper("192.168.100.128:2180, 192.168.100.128:2182, 192.168.100.128:2183", 20000 , watcher);
		zooKeeper = new ZooKeeper("localhost:2181", 20000 , watcher);
	} 
	
	public void ZKOption() throws Exception, InterruptedException {
		logger.debug("-----ZK Option-----");
		//����һ��������·��/zoo1          ���������ڵ��ϵ�����       ��������Ȩ��    �����ģ��ڵ�����
		zooKeeper.create("/zoo1", "zoo1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		//���watcher ����zoo1���м�ر仯-->��ȡ���� ,������ֻ����´β����ڵ�������
		zooKeeper.getData("/zoo1", this.watcher, null);
		//�޸�zoo1�ڵ�
		zooKeeper.setData("/zoo1", "hello".getBytes(), -1);
		//----------------------��ȡ����----------------------------
		logger.debug("��ȡ��һ�νڵ���Ϣ��"+zooKeeper.getData("/zoo1", this.watcher, null));
		System.out.println("��ȡ�ڶ���������Ϣ��"+zooKeeper.getData("/zoo1", this.watcher, null));
		//-----------------��β����Ľڵ㲻����м��-----------------------
		zooKeeper.setData("/zoo1", "world".getBytes(), -1);
		//----------------------��ȡ����----------------------------
		logger.debug("��ȡ�ڶ���������Ϣ��"+zooKeeper.getData("/zoo1", this.watcher, null));
		System.out.println("��ȡ�ڶ���������Ϣ��"+zooKeeper.getData("/zoo1", this.watcher, null));
		//�鿴�ڵ�״̬
		logger.debug("�ڵ�״̬��"+zooKeeper.getState());
		System.out.println("�ڵ�״̬��"+zooKeeper.getState());
		//ɾ���ڵ�
		zooKeeper.delete("/zoo1", -1);
		System.out.println(zooKeeper.exists("/zoo1", false));
	}
	
	//�ر�Zookeeper
	public void closeZookeeper() throws Exception {
		zooKeeper.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		ZookeeperUtils utils = new ZookeeperUtils();
		utils.zookeeperInit();
		utils.ZKOption();
		utils.closeZookeeper();
	}
	
}
