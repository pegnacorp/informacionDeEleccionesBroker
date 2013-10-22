package Broker;

import Cliente.Cliente;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Broker {
    private ArrayList<Thread> processors;
    private Socket outSocket;
    private Socket inSocket;
    
    public Broker(){
//        try {
//            inSocket = new Socket("192.168.0.1", 123);//listening address and port
//            outSocket = new Socket("192.168.0.1", 123);//server address and listening port
//            processors = new ArrayList<Thread>();
//        } catch (UnknownHostException ex) {
//            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public void createClientSocket(Cliente cliente){
        Thread clientThread = new Thread(new ProcessClient(cliente));
        processors.add(clientThread);
        clientThread.start();
    }
    
    public void processRequest(String xmlObject, int action){
     switch(action){
         case 1:
//            agregardDatos();
            break;
             
     }
    }
    
    
    /*
     * outputs the available server instructions
     */
    public void getAvailableInstructions(){
        
    }
    
    public static void main(String[] args) {
        Broker b = new Broker();
        Broker a = new Broker();
        b.createClientSocket(new Cliente());
        a.createClientSocket(new Cliente());
//        System.out.println("hi");
    }
}
