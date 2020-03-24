package cn.spring.mvn.dubbo.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class Provider {
	public static void main(String[] args) throws Exception {
        //读取配置文件
        new ClassPathXmlApplicationContext(new String[]{"dubbo-provider.xml"});
        System.out.println("provider服务已注册");
        //使线程阻塞
        System.in.read();
    }
}
