package fr.myschool.productmanager.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.myschool.productmanager.utils.PersistenceManager;

@WebListener
public class PersistenceAppListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("PersistenceAppListener - contextInit");
		PersistenceManager.getEmf();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("PersistenceAppListener - contextDestroy");
		PersistenceManager.closeEmf();
	}
}
