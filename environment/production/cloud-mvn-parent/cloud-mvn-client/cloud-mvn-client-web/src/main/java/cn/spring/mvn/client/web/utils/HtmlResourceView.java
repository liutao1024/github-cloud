package cn.spring.mvn.client.web.utils;

import java.io.File;
import java.util.Locale;

import org.springframework.web.servlet.view.InternalResourceView;
/**
 * @Author LiuTao @Date 2019年1月17日 上午11:32:33
 * @ClassName: HtmlResourceView 
 * @Description: Html视图解析器需要用到这个类
 */
public class HtmlResourceView extends InternalResourceView {
	@Override
	public boolean checkResource(Locale locale) {
		File file = new File(this.getServletContext().getRealPath("/") + getUrl());
		return file.exists();// 判断该页面是否存在
	}
}
