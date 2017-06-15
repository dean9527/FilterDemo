package com.dean.it;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("******摧毁*******");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("******过滤******");
		/*
		* 如果没有filterChain.doFilter(req, resp);
		*代码会一直拦截result.jsp，
		*后台只会不断的打印******过滤******
		*/
		filterChain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("******初始化********");
	}

}
