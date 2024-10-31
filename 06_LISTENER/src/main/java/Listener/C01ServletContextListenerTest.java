package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


//@WebListener
public class C01ServletContextListenerTest implements ServletContextListener{


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("[Listener] C01ServletContextListenerTest start...");
		
		sce.getServletContext().setAttribute("CTX_KEY", "CTX_VALUE");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("[Listener] C01ServletContextListenerTest end...");
	}
	
}
