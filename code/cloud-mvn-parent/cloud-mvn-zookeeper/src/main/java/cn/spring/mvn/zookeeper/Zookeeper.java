package cn.spring.mvn.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class Zookeeper {
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2181", 30000, new TestWatcher());
		String node = "/node3";
		//节点是否存在
		Stat stat = zookeeper.exists(node, false);
		if(null == stat){
			//创建节点
			String createResult =zookeeper.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println(createResult);
		}
		byte[] b = zookeeper.getData(node, false, stat);
		System.out.println(new String(b));
		zookeeper.close();
	}
}
class TestWatcher implements Watcher{

	@Override
	public void process(WatchedEvent event) {
		System.out.println("path"+event.getPath());
		System.out.println("type"+event.getType());
		System.out.println("state"+event.getState());
		System.out.println();
	}
	
}
