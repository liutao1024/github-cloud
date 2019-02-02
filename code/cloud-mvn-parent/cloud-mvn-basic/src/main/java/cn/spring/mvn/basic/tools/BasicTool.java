package cn.spring.mvn.basic.tools;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

public class BasicTool {
	/**
	 * @author LiuTao @date 2018年6月12日 下午1:25:10
	 * @Title: getSerial
	 * @Description: 生成一个流水号
	 * @return
	 */
	public static String getSerial() {
		UUID uuid = UUID.randomUUID();
		String serial = uuid.toString().replaceAll("-", "");
		return serial;
	}

	/**
	 * @author LiuTao @date 2018年6月12日 下午1:35:54
	 * @Title: getSerial
	 * @Description: 根据传入的key字符串获取UUID字符串,类似MD5加密
	 * @param key
	 * @return
	 */
	public static String getSerial(String key) {
		UUID uuid = UUID.nameUUIDFromBytes(key.getBytes());
		String serial = uuid.toString().replace("-", "");
		return serial;
	}

	/**
	 * @author LiuTao @date 2018年9月4日 上午9:57:19
	 * @Title: main
	 * @Description: TODO(Test Myself)
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getSerial());
		System.out.println(getSerial("123"));

	}
	/**
	 * @author LiuTao @date 2018年6月4日 下午10:03:14 
	 * @Title: getAttributeByAutowiredAnnotation 
	 * @Description:获取子类的所有带@Autowired注解的属性并将webApplicationContext中对应的bean对象赋给子类对应的属性
	 * @param fileList
	 * @return
	 */
	public static List<Object> getAttributeByAutowiredAnnotation(List<String> fileList, Class<?> parentClazz) throws Exception{
		List<String> subFileList = new ArrayList<String>();
		List<Object> subObjectList = new ArrayList<Object>();
		try {
			for(String clazzStr : fileList){
				//反射的得到子类
				if(BasicReflection.toJudgeByReflectClassIsSonOfParentClass(clazzStr, parentClazz)){
					subFileList.add(clazzStr);
				}
			}
			for(String subClazzStr : subFileList){
				Class<?> subClazz = BasicReflection.getClassByReflectClassName(subClazzStr);
				Object obj = subClazz.newInstance();
				Map<Type, Object> map = new HashMap<Type, Object>();
				map = BasicReflection.getMapByReflectAttributeAnnotationAutowiredObject(obj);
				for (Entry<Type, Object> entry : map.entrySet()) {
					Class<?> clazz = (Class<?>) entry.getKey();
					Object object = entry.getValue();
//					object = TaskJob.getService(clazz);
					subObjectList.add(object);
					System.out.println(clazz);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return subObjectList;
	}
}
