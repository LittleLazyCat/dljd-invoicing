package com.bjpowernode.web.system.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bjpowernode.web.system.manager.ClientManager;


/**
 */
public class OnlineListener implements ServletContextListener,HttpSessionListener {

	private static ApplicationContext ctx = null;

	public OnlineListener() {
	}

	
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
	}

	
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		ClientManager.getInstance().removeClinet(httpSessionEvent.getSession().getId());
	}

	/**
	 * 服务器初始化
	 */
	
	public void contextInitialized(ServletContextEvent evt) {
		ctx = WebApplicationContextUtils.getWebApplicationContext(evt.getServletContext());
	}

	public static ApplicationContext getCtx() {
		return ctx;
	}
	
	
	public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
		
	}

}
