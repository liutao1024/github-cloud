package cn.spring.mvn.zookeeper;

import java.util.List;

public class ZookeeperTest {
	public static void main(String[] args) throws Exception {
		ZookeeperWatcher zookeeper = new ZookeeperWatcher();
		zookeeper.connectZookeeper("127.0.0.1:2181");
		List<String> list = zookeeper.getChildren("/");
		System.out.println(list);
//		
	}
	
}