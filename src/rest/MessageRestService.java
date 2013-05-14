package rest;

	import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

//import com.sun.jersey.spi.resource.Singleton;
import com.sun.jersey.api.view.Viewable;	 
//	@Singleton
	@Path("/messages")
	public class MessageRestService {
		private static String user="none";
		
		
		@POST
		@Path("/logon")
		public Response loginForm(
			@FormParam("name") String name,
			@FormParam("pass") String pass) {
	 
			this.user=name+"@"+pass;
			
			System.out.println(user);
			return Response.status(200)
				.entity("User is name : " + name + ", password : *HIDDEN*")// + pass)
				.build();
	 
		}	 
		
		@GET
		@Produces("text/html")
		public Response printMessages(){
			ServletContextClass.sessionMessage.put("1","one");
			Map<String,String> testM = new HashMap<String,String>();
			testM.put("user", "value");
//			testM.put("items", Arrays.asList("1", "2", "3"));
//			List<String> l = new ArrayList<String>();
//	        l.add("light saber");
//	        l.add("fremen clothes");
	        testM.put("items1", "l");
	        testM.put("items2", "2");
	        testM.put("items3", "3");
	        testM.put("items4", "4");
	        return Response.ok(new Viewable("/message", testM)).build();
//			return Response.status(200).entity("current logon is:"+this.user).build();
		}
		
		@GET
		@Path("/{param}")
		public Response printMessage(@PathParam("param") String msg) {
	 
			String result = "Restful example : " + msg;
	 
			return Response.status(200).entity(result).build();
	 
		}
	 
	}