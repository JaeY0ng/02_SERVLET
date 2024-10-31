package Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;


@WebListener
public class C02ServletContextAttributeListenerTest implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("[Listener] : C02ServletContextListenerTest attributeAdded invoke..");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("[Listener] : C02ServletContextListenerTest attributeRemoved invoke..");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("[Listener] : C02ServletContextListenerTest attributeReplaced invoke..");
	}

	
}
