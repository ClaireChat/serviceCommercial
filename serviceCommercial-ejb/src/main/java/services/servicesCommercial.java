/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import metier.gestionCommercialLocal;

/**
 *
 * @author alban
 */
@Stateless
public class servicesCommercial implements servicesCommercialLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private gestionCommercialLocal gestionCom;
    
    
    @Override
    public String DemandeFormation(String content){
        return gestionCom.DemandeFormation(content);
    }
    
    @Override
    public String CompteRendu(String content){
        return gestionCom.CompteRendu(content);
    }
    
    
}
