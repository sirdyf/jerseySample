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

import org.jivesoftware.smack.XMPPException;

//import com.sun.jersey.spi.resource.Singleton;
import com.sun.jersey.api.view.Viewable;	 
//	@Singleton
	@Path("/messages")
	public class MessageRestService {
		
		@POST
		@Path("/")
		public Response sendMessage(			
			@FormParam("name") String name,
			@FormParam("mess") String mess){
			
			System.out.println(name+"@"+mess);
			ServletContextClass.myManager.SendMessage(name, mess);
			return Response.status(200)
				.entity("From:`" +ServletContextClass.myManager.GetSelfName()+ "` To:`"+name + "` message: "+mess)
				.build();		}
		
		@POST
		@Path("/logon")
		public Response loginForm(
			@FormParam("name") String name,
			@FormParam("pass") String pass) {
	 
			try {
				ServletContextClass.myManager.Connect(name, pass);
			} catch (XMPPException e) {
				
				e.printStackTrace();
			}

			
			System.out.println(name+"@"+pass);
			return Response.status(200)
				.entity("User is name : " + name + ", password : *HIDDEN*")// + pass)
				.build();
	 
		}	 
		
		@GET
		@Produces("text/html")
		public Response printMessages(){
			
			List<String> messageList = ServletContextClass.myManager.GetMessages();
	        return Response.ok(new Viewable("/message", messageList)).build();
//			return Response.status(200).entity("current logon is:"+this.user).build();
		}
		
		@GET
		@Path("/{param}")
		public Response printMessage(@PathParam("param") String msg) {
	 
			String result = "Restful example : " + msg;
	 
			return Response.status(200).entity(result).build();
	 
		}
	 
	}