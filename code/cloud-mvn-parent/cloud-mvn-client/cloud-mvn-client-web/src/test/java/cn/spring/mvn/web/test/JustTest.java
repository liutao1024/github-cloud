package cn.spring.mvn.web.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JustTest {
	private static final Logger logger = LoggerFactory.getLogger(JustTest.class);
	@Test
	public void Test0001(){
		logger.info("====%s====%s====", "ABC", "abc");
	}
}
