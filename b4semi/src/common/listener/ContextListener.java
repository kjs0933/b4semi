package common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import common.TimeSystem;

@WebListener
public class ContextListener implements ServletContextListener {

    public ContextListener() {}

    public void contextDestroyed(ServletContextEvent arg0)  {
    	
    }

    public void contextInitialized(ServletContextEvent arg0)
    { 
         TimeSystem.initialize();
    }
	
}
