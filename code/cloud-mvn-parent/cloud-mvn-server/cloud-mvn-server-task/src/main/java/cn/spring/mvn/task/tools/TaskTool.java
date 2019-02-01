package cn.spring.mvn.task.tools;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.spring.mvn.basic.tools.BasicReflection;

/**
 * @author LiuTao @date 2018年11月2日 下午3:02:10
 * @ClassName: TaskTools 
 * @Description: TODO(Describe)这个tool没有用到
 */
public class TaskTool {
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