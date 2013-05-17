package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;

@Path("/users")
public class userRestService {

	@GET
	public Response printUsers() {
		List<String> messageList = ServletContextClass.myManager.GetUsers();
        return Response.ok(new Viewable("/users", messageList)).build();
	}
}
