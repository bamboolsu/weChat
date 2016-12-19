package com.le.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class EcodeFilter implements Filter
{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpReq=(HttpServletRequest) req;
		String method = httpReq.getMethod();
		if("GET".equals(method)){
			Map<String, String[]> paramets = httpReq.getParameterMap();
			Set<String> keys = paramets.keySet();
			for(String key: keys){
				String[] values = paramets.get(key);
				for (int i = 0; i < values.length; i++) {
					values[i]=new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
		}
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json; charset=utf-8");
		chain.doFilter(httpReq, resp);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
