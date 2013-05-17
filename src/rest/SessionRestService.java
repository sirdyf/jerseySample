package rest;

import java.net.URI;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jivesoftware.smack.XMPPException;

import com.sun.jersey.api.view.Viewable;

@Path("/session")
public class SessionRestService {
		@GET
		public Response mainForm(){
				return Response.ok(new Viewable("/session", ServletContextClass.myManager.GetSelfName())).build();
		}
		}

