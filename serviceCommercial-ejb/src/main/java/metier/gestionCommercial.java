/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javax.ejb.Stateless;
import com.google.gson.Gson;
import entite.demandes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.json.JsonObject;
import jms.logDansJmsLocal;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author alban
 */
@Stateless
public class gestionCommercial implements gestionCommercialLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
     private Gson gson;
     
    @EJB
    private logDansJmsLocal logDansJMS;
     
     public gestionCommercial() {
        this.gson = new Gson();
    }
     
    @Override
    public String verfiForm(demandes dem){
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:8080/TechnicoCommercial-web/resources/formation/" + dem.getIdFormation());
        String message = "";
         try {
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
            String line = rd.readLine();
            if(line.equals("null")){
                message = "aucune formation ne correspond";
            }else {
                logDansJMS.sendLog(dem.toString());
                message = "Formation en demande";
            }
            
        } catch (IOException ex) {
            Logger.getLogger(gestionCommercial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return message;
    }
    
    @Override
    public String DemandeFormation(String content){
        demandes dem = this.gson.fromJson(content, demandes.class);

        return verfiForm(dem);
    }     
     
}
