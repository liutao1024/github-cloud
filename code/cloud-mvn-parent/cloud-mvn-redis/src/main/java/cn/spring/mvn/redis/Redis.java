package cn.spring.mvn.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
/**
 * Hello Redis!
 */
public class Redis {
	public static JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);
	public static Jedis jedis = jedisPool.getResource();
	public Redis(){
		System.out.println("Hello Redis!");
	}
	
	public static void main(String[] args) {
//		ConnectRedis();
//		redisJavaString();
//		redisDeleteKey();
//		redisJavaList();
		redisJavaKeys();
	}
	
	public static void ConnectRedis(){
		System.out.println(jedis.ping());
	}
	
	public static void redisJavaString(){
		jedis.set("runoobkey", "www.runoob.com");
		System.out.println(jedis.get("runoobkey"));
	}
	
	public static void redisJavaList(){
		//存入数据
		jedis.lpush("site-list", "alibaba");
		jedis.lpush("site-list", "baidu");
		jedis.lpush("site-list", "facebook");
		jedis.lpush("site-list", "google");
		jedis.lpush("site-list", "tencent");
		jedis.lpush("site-list", "twitter");
		jedis.lpush("site-list", "runoob");
		List<String> list = jedis.lrange("site-list", 0, -1);
		for (String str : list) {
			System.out.println(str);
		}
	}
	
	public static void redisJavaKeys(){
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
	}
	
	
	
	public static void redisDeleteKey(){
		jedis.del("site-list");
	}
	
}
