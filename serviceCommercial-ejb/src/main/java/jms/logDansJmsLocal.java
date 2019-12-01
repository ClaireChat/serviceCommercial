/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import javax.ejb.Local;

/**
 *
 * @author alban
 */
@Local
public interface logDansJmsLocal {
    
    public void sendLog(String formation);
}
