package org.cloud.mvn.zstudy.javaVirtualMachine.classLoading;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author LiuTao @Date 2020年9月18日 下午4:15:30
 * @ClassName: ClassLoaderTest 
 * @Description: 类加载器与instanceof关键字演示
 */
public class ClassLoaderTest {
	public static void main(String[] args) throws Exception {
		ClassLoader myLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String clazzAllName) throws ClassNotFoundException {
				try {
					String clazzName = clazzAllName.substring(clazzAllName.lastIndexOf(".") + 1) + ".class";
					InputStream inputStreams = getClass().getResourceAsStream(clazzName);
					if (inputStreams == null) {
						return super.loadClass(clazzAllName);
					}
					byte[] b_array = new byte[inputStreams.available()];
					inputStreams.read(b_array);
					return defineClass(clazzAllName, b_array, 0, b_array.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(clazzAllName);
				}
			}
		};
		Object obj = myLoader.loadClass("org.cloud.mvn.zstudy.javaVirtualMachine.classLoading.ClassLoaderTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof org.cloud.mvn.zstudy.javaVirtualMachine.classLoading.ClassLoaderTest);
	}
}