package cn.spring.mvn.redis;

import org.springframework.data.redis.core.RedisTemplate;

public class ThreadBuy extends Thread {

	private MsService service;
    private RedisTemplate<String,Object> redisTemplate;
    private String key;
 
    public ThreadBuy(MsService service,RedisTemplate<String,Object> redisTemplate,String key) {
        this.service = service;
        this.redisTemplate=redisTemplate;
        this.key=key;
    }
 
    @Override
    public void run() {
        try {
			service.seckill(redisTemplate, key);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
