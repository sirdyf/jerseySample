package rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextClass implements ServletContextListener
{
//       public static Connection con;
//	public static List<String> sessionMessage = new ArrayList<String>();
	public static Map<String,String> sessionMessage = new HashMap<String,String>();


@Override
public void contextDestroyed(ServletContextEvent arg0) {
	// 
	System.out.println("context destroyed.");
}


@Override
public void contextInitialized(ServletContextEvent sce) {
	// 
	System.out.println("context init.");
}

}