package rest;

	import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jivesoftware.smack.XMPPException;

//import com.sun.jersey.spi.resource.Singleton;
import com.sun.jersey.api.view.Viewable;	 


	@Path("/messages")
	public class MessageRestService {

		@DELETE
//		@Produces(MediaType.TEXT_HTML)
		public Response sendMessage2(){
			ServletContextClass.myManager.DeleteHistory();
			return Response.status(200)
				.entity("All message deleted.")
				.build();		
		}	
		
		@POST
		@Produces(MediaType.TEXT_HTML)
		public Response sendMessage(@Context UriInfo uriInfo,
			@FormParam("name") String name,
			@FormParam("mess") String mess){
			
			System.out.println(name+"@"+mess);
			ServletContextClass.myManager.SendMessage(name, mess);
			URI uri = uriInfo.getBaseUriBuilder().path("/session").build();
			return Response.seeOther(uri).build();
//			return Response.status(200)
//				.header("charset", "UTF-8")
//				.type(MediaType.TEXT_HTML +";charset=UTF-8")
//				.entity("From:`" +ServletContextClass.myManager.GetSelfName()+ "` To:`"+name + "` message: "+mess)
//				.build();		
			}
		
		
		@GET
		@Produces("text/html")
		public Response printMessages(){
			
			List<String> messageList = ServletContextClass.myManager.GetMessages();
	        return Response.ok(new Viewable("/message", messageList)).build();
		}
		
		@GET
		@Path("/{param}")
		public Response printMessage(@PathParam("param") String msg) {
			String result = "Restful example : " + msg;
			return Response.status(200).entity(result).build();
	 
		}
	 
	}