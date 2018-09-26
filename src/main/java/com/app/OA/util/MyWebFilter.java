package com.app.OA.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.OA.service.AccountService;

@WebFilter(filterName="mywebfilter",urlPatterns="/*")
public class MyWebFilter implements Filter{
	
	@Autowired
	AccountService  accountService;
	
	@Override
	public void destroy() {
		String name =null;
		accountService.clearStatus(name);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
			
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, If-Modified-Since");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
//		response.setHeader("Access-Control-Allow-Origin","http://192.168.2.200:8080" );//request.getHeader("Origin")
		
		//此行代码确保请求可以继续执行至Controller
		filterChain.doFilter(request, response); 

		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
