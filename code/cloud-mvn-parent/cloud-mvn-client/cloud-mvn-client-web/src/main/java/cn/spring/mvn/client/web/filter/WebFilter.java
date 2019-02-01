package cn.spring.mvn.client.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebFilter implements Filter{
	FilterConfig filterConfig = null;
	private static final String DEFAULT_CHARSET = "UTF-8";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
//		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		//httpServletRequest的参数做处理
		//url=http://127.0.0.1:8080/path/home/login.do?user=10001&paswd=123456
		String queryString = httpServletRequest.getQueryString();
		System.out.println(queryString);// user=10001&paswd=123456
		httpServletRequest.setCharacterEncoding(DEFAULT_CHARSET);
		httpServletResponse.setCharacterEncoding(DEFAULT_CHARSET);
		chain.doFilter(new WebHttpServletRequestWrapper(httpServletRequest), httpServletResponse);
	}

	@Override
	public void destroy() {
		this.filterConfig = null;
//		Filter.super.destroy();
	}
}
