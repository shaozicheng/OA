package com.app.OA.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

 class SecurityInterceptor implements HandlerInterceptor {
	/**
     * 登录session key
     */
    public final static String SESSION_KEY = "user";
    
	@Autowired
    private RedisTemplate<String, String> redisTemplate;
	
	 @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
             throws Exception {
		 
         HttpSession session = request.getSession();
         if (session.getAttribute(SESSION_KEY) != null){
         	
         	String id =redisTemplate.opsForValue().get(session.getAttribute(SESSION_KEY));
         	if(id.equals(session.getId())){
         		return true;
         	}
         	
         }
//         response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
// 		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, If-Modified-Since");
// 		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
// 		response.setHeader("Access-Control-Max-Age", "3600");
// 		response.addHeader("Access-Control-Allow-Credentials", "true");
// 		response.setCharacterEncoding("UTF-8");
// 		response.setContentType("application/json");
    	 // 跳转登录
//    	 String url = "http://192.168.2.200:8080/kongbai";//等待前台给出
//         response.addHeader("192.168.2.200", "kongbai");response.setStatus(302);
//         response.sendRedirect("http://192.168.2.200:8080/kongbai");
//         request.getRequestDispatcher("http://192.168.2.200:8080/kongbai");
         return false; 
        
         
         
     }

	 
	 
	 
 }

