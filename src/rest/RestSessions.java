package rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

@Path("/logon")
public class RestSessions {
	private String user="";
		@POST
//		@Path("/add")
		@Path("/")
		public Response loginForm(
			@FormParam("name") String name,
			@FormParam("password") String pass) {
	 
			return Response.status(200)
				.entity("User is name : " + name + ", password : *HIDDEN*" )//+ age)
				.build();
	 
		}

}
