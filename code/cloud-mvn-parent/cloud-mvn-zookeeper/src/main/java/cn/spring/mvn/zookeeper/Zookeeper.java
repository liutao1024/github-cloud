package cn.spring.mvn.zookeeper;
 
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
 
public class Zookeeper implements Watcher{
	private ZooKeeper zookeeper;
	/**
	 * 超时时间
	 */
	private static final int SESSION_TIME_OUT = 2000;
	private CountDownLatch countDownLatch = new CountDownLatch(1);
	@Override
	public void process(WatchedEvent event) {
		if (event.getState() == KeeperState.SyncConnected) {
			System.out.println("Watch received event");
			countDownLatch.countDown();
		}
	}
	/**
	 * @author LiuTao @date 2019年8月9日 上午11:37:15 
	 * @Title: connectZookeeper 
	 * @Description: 连接Zookeeper
	 * @param host
	 * @throws Exception
	 */
	public void connectZookeeper(String host) throws Exception{
		zookeeper = new ZooKeeper(host, SESSION_TIME_OUT, this);
		countDownLatch.await();
		System.out.println("zookeeper connection success");
	}

	/**
	 * @author LiuTao @date 2019年8月9日 上午11:37:33 
	 * @Title: createNode 
	 * @Description: 创建节点 
	 * @param path
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String createNode(String path,String data) throws Exception{
		return this.zookeeper.create(path, data.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}

	/**
	 * @author LiuTao @date 2019年8月9日 上午11:38:11 
	 * @Title: getChildren 
	 * @Description: 获取路径下所有子节点 
	 * @param path
	 * @return
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public List<String> getChildren(String path) throws KeeperException, InterruptedException{
		List<String> children = zookeeper.getChildren(path, false);
		return children;
	}

	/**
	 * @author LiuTao @date 2019年8月9日 上午11:38:24 
	 * @Title: getData 
	 * @Description: 获取节点上面的数据 
	 * @param path
	 * @return
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public String getData(String path) throws KeeperException, InterruptedException{
		byte[] data = zookeeper.getData(path, false, null);
		if (data == null) {
			return "";
		}
		return new String(data);
	}

	/**
	 * @author LiuTao @date 2019年8月9日 上午11:38:37 
	 * @Title: setData 
	 * @Description: 设置节点信息
	 * @param path
	 * @param data
	 * @return
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public Stat setData(String path,String data) throws KeeperException, InterruptedException{
		Stat stat = zookeeper.setData(path, data.getBytes(), -1);
		return stat;
	}

	/**
	 * @author LiuTao @date 2019年8月9日 上午11:38:47 
	 * @Title: deleteNode 
	 * @Description: 删除节点 
	 * @param path
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	public void deleteNode(String path) throws InterruptedException, KeeperException{
		zookeeper.delete(path, -1);
	}

	/**
	 * @author LiuTao @date 2019年8月9日 上午11:39:01 
	 * @Title: getCTime 
	 * @Description: 获取创建时间
	 * @param path
	 * @return
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public String getCTime(String path) throws KeeperException, InterruptedException{
		Stat stat = zookeeper.exists(path, false);
		return String.valueOf(stat.getCtime());
	}
	
	/**
	 * @author LiuTao @date 2019年8月9日 上午11:39:29 
	 * @Title: getChildrenNum 
	 * @Description: 获取某个路径下孩子的数量
	 * @param path
	 * @return
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public Integer getChildrenNum(String path) throws KeeperException, InterruptedException{
		int childenNum = zookeeper.getChildren(path, false).size();
		return childenNum;
	}
	
	/**
	 * @author LiuTao @date 2019年8月9日 上午11:39:41 
	 * @Title: closeConnection 
	 * @Description: 关闭连接
	 * @throws InterruptedException
	 */
	public void closeConnection() throws InterruptedException{
		if (zookeeper != null) {
			zookeeper.close();
		}
	}
}