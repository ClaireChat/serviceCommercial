/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Local;

/**
 *
 * @author alban
 */
@Local
public interface servicesCommercialLocal {
    
   public String DemandeFormation(String content);
   
    public String CompteRendu(String content);
}
