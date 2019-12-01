/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceCommercial;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author alban
 */
@Path("commercial")
@RequestScoped
public class CommercialResource {

    services.servicesCommercialLocal servicesCommercial = lookupservicesCommercialLocal();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CommercialResource
     */
    public CommercialResource() {
    }

    /**
     * Retrieves representation of an instance of serviceCommercial.CommercialResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "test";
    }

    /**
     * PUT method for updating or creating an instance of CommercialResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @Path("demandes")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String AjoutFormaPlan(String content) {
        //return Response.ok(gson.toJson(patri.ajouterSalle(id))).build();
        //System.out.print(id);
        return servicesCommercial.DemandeFormation(content);        
    }

    private services.servicesCommercialLocal lookupservicesCommercialLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (services.servicesCommercialLocal) c.lookup("java:global/serviceCommercial-ear/serviceCommercial-ejb-1.0-SNAPSHOT/servicesCommercial!services.servicesCommercialLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}
