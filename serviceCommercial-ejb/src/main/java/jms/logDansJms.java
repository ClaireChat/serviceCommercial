/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author alban
 */
@Stateless
public class logDansJms implements logDansJmsLocal {

    Context context = null;
    ConnectionFactory factory = null;
    Connection connection = null;
    String factoryName = "commercial";
    String destName = null;
    Destination dest = null;
    int count = 1;
    Session session = null;
    MessageProducer sender = null;

    String text = "";

    @Override
    public void sendLog(String formation) {
    destName = "commercialDestQueue";

    try {
         // create the JNDI initial context.
         context = new InitialContext();

         // look up the ConnectionFactory
         factory = (ConnectionFactory) context.lookup(factoryName);

         // look up the Destination
         dest = (Destination) context.lookup(destName);

         // create the connection
         connection = factory.createConnection();

         // create the session
         session = connection.createSession(
             false, Session.AUTO_ACKNOWLEDGE);

         // create the sender
         sender = session.createProducer(dest);

         // start the connection, to enable message sends
         connection.start();

       
           
            text = formation ;
            TextMessage message = session.createTextMessage();
            message.setText(text);
            sender.send(message);
            System.out.println(formation);
            System.out.println(message.getText());
            System.out.println();
            text = "";
    
        

     } catch (JMSException exception) {
         exception.printStackTrace();
     } catch (NamingException exception) {
         exception.printStackTrace();
     } finally {
         // close the context
         if (context != null) {
             try {
                 context.close();
             } catch (NamingException exception) {
                 exception.printStackTrace();
             }
         }

         // close the connection
         if (connection != null) {
             try {
                 connection.close();
             } catch (JMSException exception) {
                 exception.printStackTrace();
             }
         }
     }
 }
    
}
