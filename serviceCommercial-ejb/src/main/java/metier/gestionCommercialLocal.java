/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entite.demandes;
import javax.ejb.Local;

/**
 *
 * @author alban
 */
@Local
public interface gestionCommercialLocal {
    
    public String verfiForm(demandes dem);
    
    public String DemandeFormation(String content);
}
