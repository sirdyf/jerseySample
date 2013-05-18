package rest;

import java.net.URI;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jivesoftware.smack.XMPPException;

@Path("/logon")
public class logonRestService {
	@POST
	public Response loginForm(@Context UriInfo uriInfo,
		@FormParam("name") String name,
		@FormParam("pass") String pass) {
 
		if (ServletContextClass.myManager.IsConnect()==false){
			System.out.println("is NOT Connect!");
			try {
				ServletContextClass.myManager.LoginUser(name, pass);
			} catch (XMPPException e) {
				e.printStackTrace();
				return Response.status(403).build();
			}
		}else{
			System.out.println("isConnect!");
			URI uri = uriInfo.getBaseUriBuilder().path("/session").build();
			return Response.seeOther(uri).build();
		}		
		name=ServletContextClass.myManager.GetSelfName();
		
		System.out.println(name+"@"+pass);
		URI uri = uriInfo.getBaseUriBuilder().path("/session").build();
		return Response.seeOther(uri).build();
	}	
}
