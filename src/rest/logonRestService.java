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
			try {
				ServletContextClass.myManager.Connect(name, pass);
			} catch (XMPPException e) {
				e.printStackTrace();
				return Response.status(403).build();
			}
		}else{
			name=ServletContextClass.myManager.GetSelfName();
		}		

		
		System.out.println(name+"@"+pass);
//		return Response.status(200)
//			.entity("User is name : " + name + ", password : *HIDDEN*")// + pass)
//			.build();
//		URI uri = uriInfo.getBaseUriBuilder().path("../sendmessage.html").build();
		URI uri = uriInfo.getBaseUriBuilder().path("/session").build();
		return Response.seeOther(uri).build();
	}	
}
//@POST
//@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
//public Response putUser(@Context UriInfo uriInfo, 
//    MultivaluedMap<String, String> formParams) {
//
//    // snip... do work and insert user here...
//
//    URI uri = uriInfo.getBaseUriBuilder().path("user.html").build();
//    return Response.seeOther(uri).build();
//}