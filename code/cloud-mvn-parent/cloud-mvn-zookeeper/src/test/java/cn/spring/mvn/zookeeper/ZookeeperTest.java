package cn.spring.mvn.zookeeper;

import java.util.List;

public class ZookeeperTest {
	public static void main(String[] args) throws Exception {
		Zookeeper zookeeper = new Zookeeper();
		zookeeper.connectZookeeper("160.161.12.179:2181");
		List<String> list = zookeeper.getChildren("/");
		System.out.println(list);
	}
}
