package cn.spring.mvn.redis;

//import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
//import org.springframework.data.redis.core.RedisTemplate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SuppressWarnings({ "resource"/*, "unused" */})
public class RedisTest {
	JedisPool jedisPool = new JedisPool("192.168.1.128", 6379);
	Jedis jedis = jedisPool.getResource();
	public static void main(String[] args) {
		JedisPool jedisPool = new JedisPool("192.168.1.128", 6379);
//		JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);
//		Jedis jedis = new Jedis("192.168.1.125", 6379);
//		Jedis jedis = new Jedis("127.0.0.1", 6379);
//		jedis.auth("neeq");
		Jedis jedis = jedisPool.getResource();
//		jedis.get("name");
		System.out.println(jedis.get("name"));
		System.out.println(jedis.ping());
//		String osNmae = System.getProperty("os.name");
//		String user = System.getProperty("user.name");
//		System.out.println(osNmae);
//		System.out.println(user);
//		System.setIn(in);
	}
	@Resource
	private ListOperations<String, String> listOperations;
	@Test
	public void Test0001(){
//		String s = jedis.ping();
//		System.out.println(s);
//		jedis.set("gender", "男");
//		Set<String> set = jedis.keys("*");
//		for (String string : set) {
//			System.out.println(jedis.get(string));
//		}
//		RedisTemplate<String, String > redisTemplate; 
		
		listOperations.leftPush("listOperations", "listOperations");
		
	}
	/**
	 * 日志工具
	 */
	Log log = LogFactory.getLog(getClass());
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void testSys() throws Exception {
		log.info("开始");
		MsService service = new MsService();
		for (int i = 0; i < 10; i++) {
			ThreadBuy threadBuy = new ThreadBuy(service, redisTemplate, "MSKEY");
			threadBuy.start();
			log.info("*******************结束");
		}
	}
	
}
