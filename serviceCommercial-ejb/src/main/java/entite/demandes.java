/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author alban
 */
public class demandes {
    
    private String codeClient;
    private String idFormation;
    private int numEffectif;

    public demandes(String codeClient, String idFormation, int numEffectif) {
        this.codeClient = codeClient;
        this.idFormation = idFormation;
        this.numEffectif = numEffectif;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public String getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(String idFormation) {
        this.idFormation = idFormation;
    }

    public int getNumEffectif() {
        return numEffectif;
    }

    public void setNumEffectif(int numEffectif) {
        this.numEffectif = numEffectif;
    }

    @Override
    public String toString() {
        return "{idFormation:" + idFormation + ", numEffectif:" + numEffectif + ", codeClient:" + codeClient+'}';
    }

   
    
    
    
}
