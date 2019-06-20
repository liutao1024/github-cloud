package cn.spring.mvn.client.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @Author LiuTao @Date 2019年1月17日 上午10:10:23
 * @ClassName: WebHttpServletRequestWrapper 
 * @Description: 对请求Request进行自定义包装,主要是一些字符的转换
 */
public class WebHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public WebHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	/**
	 * 删除空白字符
	 * @param parameter
	 * @return
	 */
	@Override
	public String[] getParameterValues(String parameter) {
		String[] results = super.getParameterValues(parameter);
		if (results == null) {
			return null;
		}
		int count = results.length;
		String[] trimResults = new String[count];

		for (int i = 0; i < count; i++) {
			trimResults[i] = results[i].trim();
		}
		return trimResults;
	}

	/**
	 * 覆盖getParameter方法,将请求参数名和参数值都做xss过滤
	 * @param name
	 * @return
	 */
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(xssEncode(name));
		if (value != null) {
			value = xssEncode(value);
		}
		return value;
	}

	/**
	 * 覆盖getHeader方法,将请求头中参数名和参数值都做xss过滤
	 * @param name
	 * @return
	 */
	@Override
	public String getHeader(String name) {
		String value = super.getHeader(xssEncode(name));
		if (value != null) {
			value = xssEncode(value);
		}
		return value;
	}
	/**
	 * @Author LiuTao @Date 2019年1月17日 上午10:18:07 
	 * @Title: xssEncode 
	 * @Description: TODO(Describe) 
	 * @param value
	 * @return
	 */
	private String xssEncode(String value) {
//		System.out.println("---"+value+"---");
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");
		return value;
	}
}
