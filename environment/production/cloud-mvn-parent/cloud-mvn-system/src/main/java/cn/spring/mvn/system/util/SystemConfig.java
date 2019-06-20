package cn.spring.mvn.system.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import cn.spring.mvn.basic.util.BasicUtil;

/**
 * @author LiuTao @date 2019年2月22日 下午1:15:40
 * @ClassName: SystemConfiGuration 
 * @Description: 系统配置文件../resources/system.properties 主要配置的是socket端口/redis地址/redis端口等等
 * @Tipc: 里面可以写一个构造函数直接加载配置文件
 */
public class SystemConfig {
	private Properties properties;
	private Map<String, Object> map;
	/**
	 * <p>Title: 无参构造函数</p> 
	 * <p>Description: </p>
	 */
	public SystemConfig(){

	}
	/**
	 * <p>Title: 有参构造函数1</p> 
	 * <p>Description: </p> 
	 * @param properties
	 */
	public SystemConfig(Properties properties){
		this.properties = properties;
		this.map = getMapFormProperties(properties);
	}
	/**
	 * <p>Title: 有参构造函数2</p> 
	 * <p>Description: </p> 
	 * @param properties
	 */
	public SystemConfig(String fileName){
		InputStream inputStream = getClass().getResourceAsStream("/"+ fileName);//取不到这个文件爱你
    	Properties properties = new Properties();
    	try {
			properties.load(inputStream);
			this.properties = properties;
			this.map = getMapFormProperties(properties);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author LiuTao @date 2019年2月22日 下午3:30:50 
	 * @Title: getMapFormProperties 
	 * @Description: 构造函数中调用初始化map 
	 * @param properties
	 * @return
	 */
	private Map<String, Object> getMapFormProperties(Properties properties) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (Enumeration<?> enumeration = properties.propertyNames(); enumeration.hasMoreElements(); ) {
			String key = (String) enumeration.nextElement();
			map.put(key, properties.get(key));
		}
		return map;
	}
	/**
     * @author LiuTao @date 2019年2月18日 下午5:46:47 
     * @Title: getValueByKey 
     * @Description: 读取配置文件:system.properties,主要配置的是socket端口/redis地址/redis端口等等
     * @param key
     * @return
     * @throws IOException 
     */
    public Object getValueByKey(String key) throws IOException{
    	InputStream inputStream = getClass().getResourceAsStream("/system.properties");//取不到这个文件爱你
    	Properties properties = new Properties();
    	properties.load(inputStream);
    	return properties.get(key);
    }
    /**
     * @author LiuTao @date 2019年2月22日 下午2:51:21 
     * @Title: getValueByKeyAndClazz 
     * @Description: 根据key+clazz(返回值类型)得到需要类型数据
     * @param key
     * @param clazz
     * @return
     * @throws Exception
     */
	public <T> T getValueByKeyAndClazz(String key, Class<T> clazz) throws Exception{
		Object obj = getValueByKey(key);
		Object retObj = BasicUtil.convertValueTypeForDB(obj, clazz);
		return clazz.cast(retObj);
	}
	
	//
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}
