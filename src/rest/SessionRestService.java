package rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;

@Path("/session")
public class SessionRestService {
		@GET
		public Response mainForm(){
			if (ServletContextClass.myManager.IsConnect()==false){
				String result = "need authorize!";
				return Response.status(200).entity(result).build();
			}else{
				return Response.ok(new Viewable("/session", ServletContextClass.myManager.GetSelfName())).build();
			}
		}
		@DELETE
		public Response logoff(){
			ServletContextClass.myManager.LogoffUser();
			return Response.status(200).build();
		}
}

