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
    
    
    private String idFormation;
    private int numEffectif;

    public demandes(String idFormation, int numEffectif) {
        this.idFormation = idFormation;
        this.numEffectif = numEffectif;
    }

    public void setIdFormation(String idFormation) {
        this.idFormation = idFormation;
    }

    public void setNumEffectif(int numEffectif) {
        this.numEffectif = numEffectif;
    }

    public String getIdFormation() {
        return idFormation;
    }

    public int getNumEffectif() {
        return numEffectif;
    }

    @Override
    public String toString() {
        return "{" + "idFormation:" + idFormation + ", numEffectif:" + numEffectif + '}';
    }

    
    
    
}
