package com.dean.it;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharactorEncodingFilter implements Filter {
	
	private String encoding = null;
	
	@Override
	public void destroy() {
		this.encoding = null;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		if(encoding != null){
			req.setCharacterEncoding(this.encoding);
			resp.setContentType("text/html;charset="+this.encoding);
		}
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");
	}

}
