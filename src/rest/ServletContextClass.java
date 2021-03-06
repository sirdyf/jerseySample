package rest;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jivesoftware.smack.XMPPException;

public class ServletContextClass implements ServletContextListener {

	static IConnManager myManager=null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//
		if (myManager != null) 	myManager.Destroy();
		
		System.out.println("context destroyed.");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		myManager = new ConnManager();
		try {
			myManager.Init();
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("context init.");
	}

}