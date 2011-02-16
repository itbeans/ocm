package com.itbeans.orders.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/greetings/{username}")
public class GreetingsRS {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public GreetingsRS() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of GreetingsRS
     * @return an instance of String
     */
    @GET
    //@Produces("application/xml")
    @Produces("text/html")
    public String getXml(@PathParam("username") String userId) {
        // TODO return proper representation object
        //throw new UnsupportedOperationException();
    	return "<html><head></head><body>Hello, " + userId + " welcome to REST</body></html>";
    }

    /**
     * PUT method for updating or creating an instance of GreetingsRS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }

}