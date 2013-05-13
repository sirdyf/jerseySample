package rest;

	import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
	 
//	@Path("/user")
//	public class resource {
//	 
//		@POST
//		@Path("/add")
//		public Response addUser(
//			@FormParam("name") String name,
//			@FormParam("age") int age) {
//	 
//			return Response.status(200)
//				.entity("addUser is called, name : " + name + ", age : " + age)
//				.build();
//	 
//		}
//	 
//	}
	@Path("/message")
	public class MessageRestService {
	 
		@GET
		@Path("/{param}")
		public Response printMessage(@PathParam("param") String msg) {
	 
			String result = "Restful example : " + msg;
	 
			return Response.status(200).entity(result).build();
	 
		}
	 
	}